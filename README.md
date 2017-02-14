# valeMobiTeste

Sistema baseado na arquitetura Cliente-Servidor sendo:

<ul>
  <li>Cliente:  sisMercadoria_cli</li>
  <li>Servidor: webMercadoria</li>
</ul>

Devido ao tempo , não foi possível subir o projeto em algum serviço PaaS, porém rodando o serviço no servidor apache tomcat,
todas as funcionalidades exigidas foram testadas e estão funcionando 100%.

Métodos de acesso ao Web Service:

<li>http://localhost:8084/webMercadoria/ws/mercadoria/efetuaVenda</li>
<li>http://localhost:8084/webMercadoria/ws/mercadoria/efetuaCompra</li>
<li>http://localhost:8084/webMercadoria/ws/mercadoria/listarCompras</li>
<li>http://localhost:8084/webMercadoria/ws/mercadoria/listarVendas</li>
<li>http://localhost:8084/webMercadoria/ws/mercadoria/buscaMercadoriaCompra</li>
<li>http://localhost:8084/webMercadoria/ws/mercadoria/buscaMercadoriaVenda</li>

Obs: devido execução do web service em um servidor local(Tomcat), a porta de acesso (8084) pode variar,
dependendo da  sua instalação e configuração!
