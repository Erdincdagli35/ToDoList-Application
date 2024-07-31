docker build -t ./couchbase .
docker rm todo-couchbase
docker run -d --name todolist-couchbase -p 8091-8093:8091-8093 -p 11210:11210 ./couchbase