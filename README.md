# Gerar os Arquivos do gRPC
``` bash
mvn compile
```

ou

``` bash
mvn clean install
```
# Rodar o Projeto
Inicie o servidor:
``` bash 
mvn compile exec:java -Dexec.mainClass=grpc.HelloWorldServiceImpl
```

Em outro terminal, execute o cliente:
``` bash
mvn compile exec:java -Dexec.mainClass=grpc.HelloWorldClient
```

Você verá a mensagem:
Servidor: "Servidor gRPC iniciado na porta 50051".
Cliente: "Resposta do servidor: Olá, Mundo!".

# Outros
Caso haja problemas na compilação, apague a pasta target.