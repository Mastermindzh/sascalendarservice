port = 9003

runlocal:
	sbt run -Dhttp.port=$(port)

run:
	/etc/init.d/datadog-agent start
	sbt run -Dhttp.port=$(port)

run_without_datadog:
	sbt run -Dhttp.port=$(port)

prod:
	sbt start -Dhttp.port=$(port)

test:
	sbt test

scalastyle:
	sbt scalastyleGenerateConfig
	sbt scalastyle

coverage:
	sbt test
	sbt coverageReport
	open target/scala-2.11/scoverage-report/index.html

sonar:
	make coverage
	make scalastyle
	sbt sonar

docker:
	docker-compose up

build:
	rm -rf target
	rm -rf play_scala_rest_framework-1.
	sed -i -e 's/coverageEnabled := true/coverageEnabled := false/g' build.sbt
	sbt dist
	sed -i -e 's/coverageEnabled := false/coverageEnabled := true/g' build.sbt
	unzip target/universal/play_scala_rest_framework-1.0.zip
	mv play_scala_rest_framework-1.0/ target/universal/play_scala_rest_framework-1.0
	make build-docker

build-docker:
# YOU SHOULD NEVER ADD A PASSWORD LIKE THIS... (convenience > security)
	docker login -u "ica2017groepa" -p "ije2CPg4Hzc5NekyKu" 
	docker build -t ica2017groepa/sascalendar .
	docker push ica2017groepa/sascalendar