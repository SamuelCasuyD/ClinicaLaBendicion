<%-- 
    Document   : Centralizador
    Created on : 19/06/2021, 08:47:40 PM
    Author     : Alexander Elias
--%>
<%@include file="HeaderCentralizador.jsp" %>
<div class="container">    
    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">               
                <img src="img/Slider/home-slider-1.png" class="d-block w-100" alt=""/>
            </div>
            <div class="carousel-item">      
                <img src="img/Slider/home-slider-2.png" class="d-block w-100" alt=""/>
            </div>
            <div class="carousel-item">      
                <img src="img/Slider/slider-principal.jpg" class="d-block w-100" alt=""/>
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>    
</div>
<%@include file="footer.jsp" %>
