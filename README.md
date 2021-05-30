# Server Log Data Analysis with Scala

This sbt scala project analyses on how many times particular website is accessed/visted on the given date.

# Input
> Path to  the file access.log.gz 

# Output
> Generate a report at in json format with one json report line per date.

# Use cases covered
1. Find all the dates having too big number of connection (> 20000) 
2. For each date :
    - compute the list of number of access by URI for each URI.
    - compute the list of number of access per IP address for each IP address.

# How to start ? 

Fetch the source code
```
git clone 
```

# Spark sbt template

This sbt template enables you to create a new spark project 

## Package

To package your project:
```bash
sbt assembly
```

## Deploy 

Copy/Upload the fatjar to the destination
```
TARGET_LOCATION=<location>
cp target/scala-2.12/spark-sbt-template-assembly-1.0.jar $TARGET_LOCATION
```

## Run

To run your project locally:
```
JAR_PATH=$(pwd)/target/scala-2.12/spark-sbt-template-assembly-1.0.jar
spark-submit --master=local[*] --deploy-mode client --class App $JAR_PATH
```
