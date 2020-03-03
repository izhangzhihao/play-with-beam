# Play with Beam with Flink and Scala 2.12

## Usage

```sh
gradle execute -DmainClass=com.github.izhangzhihao.WordCount -Dexec.args="--runner=FlinkRunner --inputFile=gs://apache-beam-samples/shakespeare/kinglear.txt --output=gs://test/output"
```

code format: `gradle scalafmt`, more usage: https://github.com/alenkacz/gradle-scalafmt