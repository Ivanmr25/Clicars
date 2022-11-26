
<!DOCTYPE html>
<%@page import="model.Marca"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Coche"%>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>CliCars</title>
  </head>
  <body>
  	<% 
  	ArrayList<Marca> marcas = (ArrayList<Marca>)session.getAttribute("marcas");
  	ArrayList<Coche> coches = (ArrayList<Coche>)session.getAttribute("bicis");

  	
  	%>
    <div class="container-fluid shadow p-0">
      <nav class="navbar navbar-expand-xl bg-light sticky-top px-3">
        <a class="navbar-brand" href="Controller?option=home">
          <img class="svg-logo" alt="CliCars" src="img/Coches.png" />
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="row collapse navbar-collapse" id="navbarNavDropdown">
          <div class="col-12 col-xl-auto ms-auto mt-3 mt-xl-0">
            <form action="Controller?op=vamarca" method="post">
              <div class="form-group">
                <select class="form-control" name="marca" id="marca" onchange="this.form.submit()">
                  <option value="" disabled selected>Elija marca</option>
                  <option value="%">Todas</option>
                  <%
                  	for (Marca marca:marcas){%>
                  		<option value="<%=marca.getId() %>"><%=marca.getNombre() %></option>
                  <%}
                  %>
                  
                </select>
              </div>
            </form>
          </div>
          <div class="col-12 col-xl-auto mt-3 mt-xl-0">
            <form action="Controller?op=vaorder" method="post">
              
              <select class="form-control" name="order" id="order" onchange="this.form.submit()">
                <option value="" disabled selected>Ordenada por</option>
                <option value="precio asc">Precio descendente</option>
                <option value="precio desc">Precio ascendente</option>
                <option value="marca">Marca</option>
                <option value="km">KM</option>
                <option value="anio">Year</option>
                <option value="cv">CV</option>
              </select>
           
          </form>
          </div>
           
          
      </nav>
      <div class="row p-3">
        <% for (Coche car : coches) { %>
	        <div class="col-12 col-md-6 col-lg-4 mb-4">
	          <div class="card h-100 bg-dark text-white" >
	            <img class="card-img-top" src="<%=car.getFoto()%>" alt="" />
	            <div class="card-body">
	            <%
        		String fav =(String) session.getAttribute("fav");
        		if (fav.equals("%")) {%>
        			<a href="Controller?op=vafav&fav=1"><span class="display-4 text-secondary">&#9733;</span></a>  
        		<%}
        		else {%>
        			<a href="Controller?op=vafav&fav=0"><span class="display-4 text-warning">&#9733;</span></a> 
        		<%}
        	%> 
               
                <div class="row">
                  <div class="col-8 col-sm-8 flex-fill">
	                  <h5 class="card-title"><%=car.getNombre()%></h5>
	                  <h6 class="card-text"><%=car.getModelo()%></h6>
	                  <p><%=car.getAnio()%> | <%=car.getKm()%>km | <%=car.getCv()%>CV</p>
                  </div>
                  <div class="col-auto col-sm-auto text-end">
                    <p class="text-danger"><%=car.getPrecioantes()%> &euro;</p>
                    <p class="text-success"><%=car.getPrecio()%> &euro;</p>
                  </div>
                </div>
	            </div>
	          </div>
	        </div>
        <% } %>
      </div>
          <footer class="bg-primary p-3 text-center text-white"><h2>&copy; Frank Pulished</h2></footer>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
      crossorigin="anonymous">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
    	$('#marca').val('<%=session.getAttribute("marca") %>')
    	$('#order').val('<%=session.getAttribute("order") %>')
  
    </script>
  </body>
</html>