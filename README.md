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
--project=??? \
--tempLocation=gs://play-with-beam/tmp \
--inputFile=gs://apache-beam-samples/shakespeare/kinglear.txt \
--output=gs://play-with-beam/output"
```

code format: `gradle scalafmt`, more usage: https://github.com/alenkacz/gradle-scalafmt