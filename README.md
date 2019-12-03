# Introduction

This is a POC to test how Refreshable annotation works on Micronaut framework. In this example, a simple REST endpoint is exposed to return the content of 2 values read from properties. Controller is annotated with Refreshable so when the RefreshEvent is triggered, both property values should be updated.

The idea is to read property values from 2 different sources (external file and Consul) and see the behaviour in both cases.

# Run and configure Consul

This project is already configured to use Consul as Distributed Configuration source. In case you want to test it locally, you can do it easily with docker executing the following command:

```
docker run -p 8500:8500 consul
```

Once it is up and running, you can access to the web interface http://localhost:8500. You just have to go to "Key/Value" section and create the file *application* within a folder called *config* (Micronaut has some default files from it will import the properties but this location is enough).

In that file you have to define the property **consul.message**. For this example I'm using yaml, so it can be something like this:

```
consul:
  message: "This is a message defined in Consul"
```

# Running the service

As I mentioned before, one of the properties that will be read by the service will be defined in an external file. Micronaut will check (among others) all the files defined in environent variable **MICRONAUT_CONFIG_FILES** to load all the properties defined on these files. In my case, I have created a file called **externalFile.yml** in this folder and it is being specified to Micronaut when the service is run. If you check the file [gradle.build](poc/build.gradle), you can see:

```
run {
    environment "MICRONAUT_CONFIG_FILES", "${projectDir}/../externalFile.yml"
}
```

In that file a property **externalFile.message** is defined.

To run the service you just have to execute the following command:

```
cd poc && ./gradlew run
```

To test the endpoint you just have to execute the following command:

```
curl --request GET --url http://localhost:8080/hello
```

if everything is properly configured, you get something similar to this:

```
Consul message: This is a message defined in consul
External file message: This is a message defined in an external file
```

# Refresh endpoint

Micronaut offers the possibility to "refresh" some bean values in case some properties change. One of the options to do that is through the **/refresh** endpoint. You can get more information about it [here](https://docs.micronaut.io/latest/guide/index.html#refreshEndpoint).

As the controller is annotated with **Refreshable** annotation, when the RefreshEvent is listened, it will update the value of the properties in case they have changed without restarting the service. 

You can try to update some value in Consult and execute the following command:

```
curl --request POST --url http://localhost:8080/refresh
```

This endpoint returns the list of properties that has been changed. If you execute again the curl to *hello* endpoint, you should get the updated message.

**NOTE:** It seems that all properties updated from external file are not bean refreshed, so an issue to Micronaut has been opened.