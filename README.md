# Play with Beam with Flink and Scala 2.12

## Usage

```sh
gradle execute -DmainClass=com.github.izhangzhihao.WordCount \
-Dexec.args="--runner=FlinkRunner \
--inputFile=gs://apache-beam-samples/shakespeare/kinglear.txt \
--output=gs://play-with-beam/output"
```

```sh
gradle execute -DmainClass=com.github.izhangzhihao.WordCount \
-Dexec.args="--runner=DataflowRunner \
--project=run-a-pyspar-93-0684d3 \
--tempLocation=gs://play-with-beam/tmp \
--inputFile=gs://apache-beam-samples/shakespeare/kinglear.txt \
--output=gs://play-with-beam/output"
```

more command line usage: https://beam.apache.org/documentation/runners/dataflow/ & https://beam.apache.org/documentation/runners/flink/

code format: `gradle scalafmt`, more usage: https://github.com/alenkacz/gradle-scalafmt