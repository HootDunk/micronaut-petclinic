if [ ! "$(docker ps -q -f name=petclinic-postgres-db)" ]; then
  docker-compose up -d
fi
export JDBC_URL=jdbc:postgresql://localhost:5432/petclinic
export JDBC_USER=petclinic
export JDBC_PASSWORD=petclinic
export JDBC_DRIVER=org.postgresql.Driver
./gradlew run