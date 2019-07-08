necessario possuir docker, java 1.8

docker pull postgres
mkdir -p $HOME/docker/volumes/postgres
docker run --rm --name pg-docker -e POSTGRES_PASSWORD=docker -d -p 5432:5432 -v $HOME/docker/volumes/postgres:/var/lib/postgresql/data postgres
abrir pg admin conforme foto conexao pgadmin.png em anexo
executar transportdora1.sql

entrar em https://www.soapui.org/downloads/soapui.html
fazer download do SoapUI OpenSource
executar SoapUI-x64-5.5.0.sh para instalar soapUI para poder mockar as transportadoras 2, 3 e 4
dentro do soapUI importar projeto REST-Project-1-soapui-project.xml
duplo clique em "REST Mock transp"
clicar start

importar Cardboardbox.postman_collection.json no postman
