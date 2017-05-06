<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
   <%@ page import="dao.*"%>
   <%@ page import="dto.*"%>
   <%@page import= "java.util.ArrayList" %>
   <%@page import= "java.time.LocalDate" %>
   <%@page import="java.time.ZoneId"%>
   <%@ page import="java.util.*,java.text.*"%>
   <%@page import="java.sql.Date"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
     
<%

ManagerDAO dao= new ManagerDAO();
Manager ml= null;

 ml=(Manager)session.getAttribute("manager");
 session.setAttribute( "manager",ml );
 if (ml == null)
 {
	 this.getServletContext().getRequestDispatcher( "/Connexion.jsp" ).forward( request, response);
	 session.removeAttribute("manager");
 }
	String IdClient="0";
	if((String)session.getAttribute("IdClient")!=null)
	{
	IdClient = (String)session.getAttribute("IdClient");
	}
	ZoneId z = ZoneId.systemDefault();
	LocalDate today = LocalDate.now( z );
	LocalDate FiveMonthBefore = today.minusMonths(5);
	LocalDate FourMonthBefore = today.minusMonths(4);
	LocalDate ThreeMonthBefore = today.minusMonths(3);
	LocalDate TwoMonthBefore = today.minusMonths(2); 
	LocalDate OneMonthBefore = today.minusMonths(1);
	LocalDate ThisMonth = today;
	
	Date datebefore6 = Date.valueOf(FiveMonthBefore);
	Date datebefore5 = Date.valueOf(FourMonthBefore);
	Date datebefore4 = Date.valueOf(ThreeMonthBefore);
	Date datebefore3 = Date.valueOf(TwoMonthBefore);
	Date datebefore2 = Date.valueOf(OneMonthBefore);
	Date datebefore1 = Date.valueOf(ThisMonth);
	
	  //System.out.println(datebefore.toString());
		HistoriqueDAO hd = new HistoriqueDAO();
	    ClientDAO cd = new ClientDAO();
	    CompteDAO cpd = new CompteDAO();
	    
	    ArrayList<Historique> lh = hd.getMoisHistorique(6,Integer.parseInt(IdClient));
	    ArrayList<Historique> llh = new ArrayList<Historique>();
	    ArrayList<String> NomPrenom = new ArrayList<String>();
    ArrayList<String> NumeroCompte = new ArrayList<String>();
    ArrayList<String> TypeCompte = new ArrayList<String>();
    int i = 0;
    for(i=0; i<lh.size();i++)
    {
    	llh.add(lh.get(i));
    	String textN = lh.get(i).getNature();
    	String nature = textN.replace('\n', '\t');    	
    	llh.get(i).setNature(nature);
    	int idClient = llh.get(i).getIdClient_historique();
    	String nomClient = cd.getClient(idClient).getNomClient();   
    	String prenomClient = cd.getClient(idClient).getPrenomClient();
    	NomPrenom.add(nomClient+'\t'+prenomClient);
    	
    	//System.out.println(NomPrenom.get(i));
    	String nc = cpd.getCompteChoisi(lh.get(i).getIdCompte_historique()).getNumeroDeCompte();
    	String tc = cpd.getCompteChoisi(lh.get(i).getIdCompte_historique()).getTypeCompte();   	
    	NumeroCompte.add(nc);
    	TypeCompte.add(tc);
    	//System.out.println(NumeroCompte.get(i));
    }
    request.setAttribute("llh", llh);
%>

<% 
         int a=0;
         int n=0;
         int t=0;
         int e=0;
         int r=0;
         int d=0;
         double se=0;
         double sr=0;
         double sd=0;
         
         int ee=0;
         int re=0;
         int de=0;
         double mee=0;
         double mre=0;
         double mde=0;
         
         
         int ec=0;
         int rc=0;
         int dc=0;
         double mec=0;
         double mrc=0;
         double mdc=0;
         
         int et=0;
         int rt=0;
         int dt=0;
         double met=0;
         double mrt=0;
         double mdt=0;
         
         double md6=0;
         double md5=0;
         double md4=0;
         double md3=0;
         double md2=0;
         double md1=0;
         
         double ve6=0;
         double ve5=0;
         double ve4=0;
         double ve3=0;
         double ve2=0;
         double ve1=0;
         
         double vr1=0;
         double vr2=0;
         double vr3=0;
         double vr4=0;
         double vr5=0;
         double vr6=0;
         
         int nve6=0;
         int nvr6=0;
         
         int nve5=0;
         int nvr5=0;
         
         int nve4=0;
         int nvr4=0;
         
         int nve3=0;
         int nvr3=0;
         
         int nve2=0;
         int nvr2=0;
         
         int nve1=0;
         int nvr1=0;
         
         int nd6=0;
         int nd5=0;
         int nd4=0;
         int nd3=0;
         int nd2=0;
         int nd1=0; 
         
         
       %>
<!DOCTYPE html>
<html>
<head>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Equipe5">

    <title>Liste Historique</title>

	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/custom.css">
    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


	<!-- Custom Fonts -->
	<link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
	<link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

	<!-- Theme CSS -->
	<link href="css/agency.min.css" rel="stylesheet">
	<link href="css/menu.css" rel="stylesheet">



</head>


 


<body id="page-top" class="index">

    <div class="wrap">
  <nav class="nav-bar navbar-inverse" role="navigation">
      <div id ="top-menu" class="container-fluid active">
          <a class="navbar-brand" href="#">BIENVENUE SUR VOTRE ESPACE MANAGERIAL</a>
          <ul class="nav navbar-nav">        
              <li class="dropdown movable">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="caret"></span><span class="fa fa-3x fa-child"></span></a>
                  <ul class="dropdown-menu" role="menu">
                      <li> <a ><span class="fa fa-user"></span> Bienvenue ${sessionScope.manager.nomManager} </a></li>
                      <li class="divider"></li>
                      <li><a data-toggle="modal" data-target="#myModal"><span class="fa fa-power-off"></span> D�connexion</a></li>
                  </ul>
              </li>
              
          </ul>
      </div>      
  </nav>
  <aside id="side-menu" class="aside" role="navigation">            
            <ul class="nav nav-list accordion">   
                         
          <li class="nav-header">
            <div class="link"><i class="fa fa-lg fa-user"></i>Clients<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
              <li><a href="ListeClient.jsp"> Voir la liste client</a></li>   
              <li><a href="ChoixListeHistorique.jsp"> Voir le reporting totale</a></li> 
              
            </ul>
          </li>
          
                    <li class="nav-header">
            <div class="link"><i class="fa fa-lg fa-user"></i>Actualit�s<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
              <li><a href=""> Ajouter / Modifier</a></li>   
              <li><a href="index.jsp#portfolio"> Consulter</a></li> 
              
            </ul>
          </li>
          
          </ul>
          
  </aside>
  
   <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"
			integrity="sha384-mE6eXfrb8jxl0rzJDBRanYqgBxtJ6Unn4/1F7q4xRRyIw7Vdg9jP4ycT7x1iVsgb"
			crossorigin="anonymous"></script>
    <script src="js/menu.js"></script>
    
  
  <!--Body content-->
  
  <div class="content">
    <div class="top-bar">       
      <a href="#menu" class="side-menu-link burger"> 
        <span class='burger_inside' id='bgrOne'></span>
        <span class='burger_inside' id='bgrTwo'></span>
        <span class='burger_inside' id='bgrThree'></span>
      </a>      
    </div>
     <%
   if(llh.size()==0)
   {%>
	<H3>IL n'y a pas d'historique dans les 6 mois pr�c�dents.</H1>    
  <%
  }
   else{
  %>  
    <section class="content-inner">
    
        <div class="container">
     <form name=""  action="Deconnexion" method="post" id="" novalidate>        
            <!-- Modal -->
             <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">�</span></button>
                    <h4 class="modal-title" id="myModalLabel">D�connexion</h4>
                  </div>
                  <div class="modal-body">
                    �tes-vous s�r de vouloir vous d�connecter ?
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
                    <button type="submit"  class="btn btn-primary">Se Deconnecter</button>
                  </div>
                </div>
              </div>
            </div>
            </form>
            </div>
            
        <h4 class="text-center"> Reporting sur les historiques 6 mois pr�c�dents</h4>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
       
      
       
     
       <!--Table and divs that hold the pie charts-->
    <table class="columns">
      <tr>
        <td><div id="Sarah_chart_div" style="border: 1px solid #ccc"></div></td>
        <td><div id="chart_div" style="border: 1px solid #ccc"></div></td>
      </tr>
    </table>
    
    
      
     
      
       <!--Table and divs that hold the pie charts-->
    <table class="columns">
      <tr>  
        <td><div id="Anthony_chart_div" style="border: 1px solid #ccc"></div></td> 
        <td><div id="chart_div1" style="border: 1px solid #ccc"></div></td>
      </tr>  
    </table>
    
    <!--Table and divs that hold the pie charts-->
    <h4>R�partition du virement �mis  sur les 3 type de compte:</h3>
    <table class="columns" >
      <tr>
      <%if(ee==0&&ec==0&&et==0){ %>  
        <td><div id="ETN_chart_div" style="border: 1px solid #ccc"></td>     
        <td><div id="ETM_chart_div" style="border: 1px solid #ccc"></td>
      <%}else{%>
      <td>Il n'y pas de virement �mis dans les 6 mois pr�c�dents</td>
      <%}%>
      </tr>  
    </table>  
    <br>
    
    <!--Table and divs that hold the pie charts-->
    <h4>R�partition du virement re�ue sur les 3 type de compte:</h3>
    <table class="columns">
      <tr>  
      <%if(re==0&&rc==0&&rt==0){ %> 
        <td><div id="RTN_chart_div" style="border: 1px solid #ccc"></td>
        <td><div id="RTM_chart_div" style="border: 1px solid #ccc"></td>
       <%}else{%>
      <td>Il n'y pas de virement re�ue dans les 6 mois pr�c�dents</td>
      <%}%>
      </tr>  
    </table>
    <br>
    <!--Table and divs that hold the pie charts-->
    <h4>R�partition du d�p�t sur les 3 type de compte:</h3>
    <table class="columns">
      <tr>  
      <%if(de==0&&dc==0&&dt==0){ %> 
        <td><div id="DTN_chart_div" style="border: 1px solid #ccc"></td>
        <td><div id="DTM_chart_div" style="border: 1px solid #ccc"></td>
      </tr>  
      <%}else{%>
      <td>Il n'y pas de d�p�t dans les 6 mois pr�c�dents</td>
      <%}%>
    </table>
    <br>
    
    <br>
    <button onclick="Afficher()">Afficher/Cacher les historiques</button>
    <br>
    <br>
   
    <div id="table_div"></div>
    
    <br>
    
      
    
    
    
    
  
    <script> 
    <c:forEach var = "h" items = "${llh}"> 
    <c:choose>
    
    <c:when test="${(!h.getNature().equals('D�p�t'))}">
    
    <c:choose>
    <c:when test="${(h.getDebit()!=0)}">
    <% e=e+1;%>
    <% se = se+llh.get(t).getDebit();%>
    </c:when>
    
    <c:otherwise>
    <% r=r+1;%>
    <% sr = sr+llh.get(t).getCredit();%>
    </c:otherwise>
    </c:choose>
    
    </c:when>      
    <c:otherwise>
    <% d=d+1; 
       sd=sd+llh.get(t).getCredit();
       //System.out.println("Montant de depot:"+sd);
       %>
    </c:otherwise>
    
    </c:choose> 
    
    <%//========================================================================%>  
    
    
    <% if(TypeCompte.get(t).equals("compte epargne")) {%>
   
    <c:choose>   
    <c:when test="${(!h.getNature().equals('D�p�t'))}">
    
    
    <c:choose>
    <c:when test="${(h.getDebit()!=0)}"> 
    <% ee=ee+1;%>
    <% mee = mee+llh.get(t).getDebit();
       System.out.println("Nombre de virement emis compte epargne"+ee);%>
    </c:when>
    
    <c:otherwise>
    <% re=re+1;%>
    <% mre = mre+llh.get(t).getCredit();%>
    </c:otherwise>
    </c:choose>
    
    </c:when>      
    <c:otherwise>
    <% de=de+1; 
       mde=mde+llh.get(t).getCredit();
       System.out.println("Montant de depot compte epargne:"+mde);
       %>
    </c:otherwise>
    
    </c:choose>
    
    
    <%}%>
    
    <%//---------------------------------------------------%>
    
    <% if(TypeCompte.get(t).equals("compte courant")) {%>
    
    <c:choose>   
    <c:when test="${(!h.getNature().equals('D�p�t'))}">
    
    
    <c:choose>
    <c:when test="${(h.getDebit()!=0)}">
    <% ec=ec+1;%>
    <% mec = mec+llh.get(t).getDebit();
       System.out.println("Nombre de virement emis compte courant"+ee);%>
    </c:when>
    
    <c:otherwise>
    <% rc=rc+1;%>
    <% mrc = mrc+llh.get(t).getCredit();%>
    </c:otherwise>
    </c:choose>
    
    </c:when>      
    <c:otherwise>
    <% dc=dc+1; 
       mdc=mdc+llh.get(t).getCredit();
       System.out.println("Montant de depot compte courant:"+mdc);
       %>
    </c:otherwise>
    
    </c:choose>
    
    
    <%}%>
    
    <%//------------------------------------------------------%>
 <% if(TypeCompte.get(t).equals("compte titre")) {%>
    
    <c:choose>   
    <c:when test="${(!h.getNature().equals('D�p�t'))}">
    
    
    <c:choose>
    <c:when test="${(h.getDebit()!=0)}">
    <% et=et+1;%>
    <% met = met+llh.get(t).getDebit();
       System.out.println("Nombre de virement emis compte titre"+et);%>
    </c:when>
    
    <c:otherwise>
    <% rt=rt+1;%>
    <% mrt = mrt+llh.get(t).getCredit();%>
    </c:otherwise>
    </c:choose>
    
    </c:when>      
    <c:otherwise>
    <% dt=dt+1; 
       mdt=mdt+llh.get(t).getCredit();
       System.out.println("Montant de depot compte titre:"+mdt);
       %>
    </c:otherwise>
    
    </c:choose>
    
    
    <%}%>
    
    
    
    
    <%//========================================================================%>
  
    <%
    if(llh.get(t).getDate().getMonth()+1 == FiveMonthBefore.getMonthValue())
    {   
        System.out.println("Two month before\n");
 	   System.out.println(lh.get(t).getDate().getMonth());
        
 	   if(!llh.get(t).getNature().equals("D�p�t"))
  	  {
 	   if(llh.get(t).getDebit()==0)
 	   {
 		   vr6=vr6+llh.get(t).getCredit();
 		   nvr6=nvr6+1;
 	   }
 	   else{
 		   ve6=ve6+llh.get(t).getDebit();
 		   nve6=nve6+1;
 	   }
 	   
  	 }
 	   else
 	   {
 		   nd6=nd6+1;
 		   md6=md6+llh.get(t).getCredit();
 		   System.out.println("Montant de depot6:"+md6);
 	   }
    }
    
    if(llh.get(t).getDate().getMonth()+1 == FourMonthBefore.getMonthValue())
    {   
        System.out.println("Two month before\n");
 	   System.out.println(lh.get(t).getDate().getMonth());
        
 	   if(!llh.get(t).getNature().equals("D�p�t"))
   	  {
 	   if(llh.get(t).getDebit()==0)
 	   {
 		   vr5=vr5+llh.get(t).getCredit();
 		   nvr5=nvr5+1;
 	   }
 	   else{
 		   ve5=ve5+llh.get(t).getDebit();
 		   nve5=nve5+1;
 	   }
   	}
 	   else
 	   {
 		   nd5=nd5+1;
 		   md5=md5+llh.get(t).getCredit();
 		   System.out.println("Montant de depot5:"+md5);
 	   }
    }
    
    if(llh.get(t).getDate().getMonth()+1 == ThreeMonthBefore.getMonthValue())
    {   
        System.out.println("Two month before\n");
 	   System.out.println(lh.get(t).getDate().getMonth());
        
 	   if(!llh.get(t).getNature().equals("D�p�t"))
    	  {
 	   if(llh.get(t).getDebit()==0)
 	   {
 		   vr4=vr4+llh.get(t).getCredit();
 		   nvr4=nvr4+1;
 	   }
 	   else{
 		   ve4=ve4+llh.get(t).getDebit();
 		   nve4=nve4+1;
 	   }
    	}
 	   else
 	   {
 		   nd4=nd4+1;
 		   md4=md4+llh.get(t).getCredit();
 		   System.out.println("Montant de depot4:"+md4);
 	   }
    }
    
    if(llh.get(t).getDate().getMonth()+1 == TwoMonthBefore.getMonthValue())
    {   
        System.out.println("Two month before\n");
 	   System.out.println(lh.get(t).getDate().getMonth());
        
 	   if(!llh.get(t).getNature().equals("D�p�t"))
     {
 	   if(llh.get(t).getDebit()==0)
 	   {
 		   vr3=vr3+llh.get(t).getCredit();
 		   nvr3=nvr3+1;
 	   }
 	   else{
 		   ve3=ve3+llh.get(t).getDebit();
 		   nve3=nve3+1;
 	   }
     }
 	   else
 	   {
 		   nd3=nd3+1;
 		   md3=md3+llh.get(t).getCredit();
 		   System.out.println("Montant de depot3:"+md3);
 	   }
    }
    
    if(llh.get(t).getDate().getMonth()+1 == OneMonthBefore.getMonthValue())
    {
 	   System.out.println("One month before\n");
 	   System.out.println(lh.get(t).getDate().getMonth()+1);
 	   
 	   if(!llh.get(t).getNature().equals("D�p�t"))
        {
 	   if(llh.get(t).getDebit()==0)
 	   {
 		   vr2=vr2+llh.get(t).getCredit();
 		   nvr2=nvr2+1;
 	   }
 	   else{
 		   ve2=ve2+llh.get(t).getDebit();
 		   nve2=nve2+1;
 	   }
        }
 	   else
 	   {
 		   nd2=nd2+1;
 		   md2=md2+llh.get(t).getCredit();
 		   System.out.println("Montant de depot2:"+md2);
 	   }
    }
    
    if(llh.get(t).getDate().getMonth()+1 == ThisMonth.getMonthValue())
    {
 	   System.out.println("This month\n");
 	   System.out.println(lh.get(t).getDate().getMonth());
 	   System.out.println(ThisMonth.getMonthValue());
 	   
 	   if(!llh.get(t).getNature().equals("D�p�t"))
        {
 	   if(llh.get(t).getDebit()==0)
 	   {
 		   vr1=vr1+llh.get(t).getCredit();
 		   nvr1=nvr1+1;
 	   }
 	   else{
 		   ve1=ve1+llh.get(t).getDebit();
 		   nve1=nve1+1;
 	   }
        }
 	   else
 	   {
 		   nd1=nd1+1;
 		   md1=md1+llh.get(t).getCredit();
 		   System.out.println("Montant de depot1:"+md1);
 	   }
    }
    
    %>
    <% t=t+1;%>
    
    </c:forEach>    
    
    
    
    
    
    
    google.charts.load('current', {'packages':['corechart', 'table']});
    google.charts.setOnLoadCallback(drawTable);   
    google.charts.setOnLoadCallback(drawSarahChart);
    google.charts.setOnLoadCallback(drawVisualization);
    google.charts.setOnLoadCallback(drawAnthonyChart);
    google.charts.setOnLoadCallback(drawVisualization1);
    
    function Afficher()
    {   
    	var x = document.getElementById("table_div");  	
    	 if(x.style.display=="none")
        {
    		 x.style.display="block";
        }
    	 else
        {
    		 x.style.display="none";
        }
    }
    
    function drawTable() {
      var data = new google.visualization.DataTable();
      
      data.addColumn('string', 'Nom/Prenom du Client');
      data.addColumn('string', 'id Client');
      data.addColumn('string', 'id Compte');
      data.addColumn('string', 'Numero du compte')
      data.addColumn('string', 'Date');
      data.addColumn('string', 'Nature');
      data.addColumn('string', 'Debit');
      data.addColumn('string', 'Credit');
       
      
      
      
      <c:forEach var = "h" items = "${llh}">   
     
      data.addRows([
        ['<%=NomPrenom.get(n)%>','<c:out value="${h.getIdClient_historique()}"/>', '<c:out value="${h.getIdCompte_historique()}"/>', '<%=NumeroCompte.get(n)%>', '<c:out value="${h.getDate()}"/>', '<c:out value="${h.getNature()}"/>', '<c:out value="${h.getCredit()}"/>', '<c:out value="${h.getDebit()}"/>']
    ]);
      
      <% n=n+1;%>
      </c:forEach>
      
      var table = new google.visualization.Table(document.getElementById('table_div'));
      table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
    }
     <%--  <% 
         System.out.println("nombre de virement emis1:");
         System.out.println(nve1);
         System.out.println("nombre de virement emis2:");
         System.out.println(nve2);
         System.out.println("nombre de virement emis3:");
         System.out.println(nve3);
         System.out.println("nombre de virement recue1:");
         System.out.println(nvr1);
         System.out.println("nombre de virement recur2:");
         System.out.println(nvr2);
         System.out.println("nombre de virement recue3:");
         System.out.println(nvr3);
         System.out.println("Virement emis1");
         System.out.println(ve1);
         System.out.println("Virement emis2");
         System.out.println(ve2);
         System.out.println("Virement emis3");
         System.out.println(ve3);
         System.out.println("Virement recue1");
         System.out.println(vr1);
         System.out.println("Virement recue1");
         System.out.println(vr2);
         System.out.println("Virement recue1");
         System.out.println(vr3);
         
         
      %> --%>
    
    //=============================================================================================================================
  	
      google.charts.setOnLoadCallback(drawETNChart);	
      google.charts.setOnLoadCallback(drawETMChart);
      
      
      function drawETNChart() {

          // Create the data table for Sarah's pizza.
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'Topping');
          data.addColumn('number', 'Slices');
          data.addRows([
        	  ['Nombre de virement �mis du compte �pargne', <%=ee%>], 
            ['Nombre de virement �mis du compte courant', <%=ec%>],
            ['Nombre de virement �mis du compte titre', <%=et%>]
          ]);

          // Set options for Sarah's pie chart.
          var options = {title:'R�partition du nombre de Nombre de virement �mis',
                         width:550,
                         height:400};

          // Instantiate and draw the chart for Sarah's pizza.
          var chart = new google.visualization.PieChart(document.getElementById('ETN_chart_div'));
          chart.draw(data, options);
        }
      
      function drawETMChart() {
          var data = google.visualization.arrayToDataTable([
            ['Montant de virement �mis du compte �pargne', 'Type de compte'],
            ['Montant de virement �mis du compte �pargne',     <%=mee%>],
            ['Montant de virement �mis du compte courant',      <%=mec%>],
            ['Montant de virement �mis du compte titre',  <%=met%>]
          ]);

          var options = {
            title: 'R�partition du montant de virement �mis',
            pieHole: 0.4,
            width:550,
            height:400
          };

          var chart = new google.visualization.PieChart(document.getElementById('ETM_chart_div'));
          chart.draw(data, options);
        }
//===============================================================================================================================
		google.charts.setOnLoadCallback(drawRTNChart);	
      google.charts.setOnLoadCallback(drawRTMChart);
      
      
      function drawRTNChart() {

          // Create the data table for Sarah's pizza.
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'Topping');
          data.addColumn('number', 'Slices');
          data.addRows([
        	  ['Nombre de virement re�ue du compte �pargne', <%=re%>], 
            ['Nombre de virement re�ue du compte courant', <%=rc%>],
            ['Nombre de virement re�ue du compte titre', <%=rt%>]
          ]);

          // Set options for Sarah's pie chart.
          var options = {title:'R�partition du nombre de virement re�ue',
                         width:550,
                         height:400};

          // Instantiate and draw the chart for Sarah's pizza.
          var chart = new google.visualization.PieChart(document.getElementById('RTN_chart_div'));
          chart.draw(data, options);
        }
      
      function drawRTMChart() {
          var data = google.visualization.arrayToDataTable([
            ['Montant', 'Type de transaction'],
            ['Montant de virement re�ue du compte �pargne',     <%=mre%>],
            ['Montant de virement re�ue du compte courant',      <%=mrc%>],
            ['Montant de virement re�ue du compte titre',  <%=mrt%>]
          ]);

          var options = {
            title: 'R�partition du montant de virement',
            pieHole: 0.4,
            width:550,
            height:400
          };

          var chart = new google.visualization.PieChart(document.getElementById('RTM_chart_div'));
          chart.draw(data, options);
        }

    //===============================================================================================================================
		google.charts.setOnLoadCallback(drawDTNChart);	
      google.charts.setOnLoadCallback(drawDTMChart);
      
      
      function drawDTNChart() {

          // Create the data table for Sarah's pizza.
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'Topping');
          data.addColumn('number', 'Slices');
          data.addRows([
        	  ['Nombre D�p�t du compte �pargne', <%=de%>], 
            ['Nombre D�p�t du compte courant', <%=dc%>],
            ['Nombre D�p�t du compte titre', <%=dt%>]
          ]);

          // Set options for Sarah's pie chart.
          var options = {title:'R�partition du nombre de d�p�t',
                         width:550,
                         height:400};

          // Instantiate and draw the chart for Sarah's pizza.
          var chart = new google.visualization.PieChart(document.getElementById('DTN_chart_div'));
          chart.draw(data, options);
        }
      
      function drawDTMChart() {
          var data = google.visualization.arrayToDataTable([
            ['Montant', 'Type de transaction'],
            ['Montant D�p�t du compte �pargne',     <%=mde%>],
            ['Montant D�p�t du compte courant',      <%=mdc%>],
            ['Montant D�p�t du compte titre',  <%=mdt%>]
          ]);

          var options = {
            title: 'R�partition du montant de d�p�t',
            pieHole: 0.4,
            width:550,
            height:400
          };

          var chart = new google.visualization.PieChart(document.getElementById('DTM_chart_div'));
          chart.draw(data, options);
        }
	
	    	
//=============================================================================================================================
	
        

        // Draw the pie chart for Sarah's pizza when Charts is loaded.
       
        

        // Callback that draws the pie chart for Sarah's pizza.
        function drawSarahChart() {

          // Create the data table for Sarah's pizza.
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'Topping');
          data.addColumn('number', 'Slices');
          data.addRows([
        	['Nombre de d�p�t', <%=d%>],
            ['Nombre de virement �mis', <%=e%>],
            ['Nombre de virement re�ue', <%=r%>]
          ]);

          // Set options for Sarah's pie chart.
          var options = {title:'Situation du nombre de virement',
                         width:450,
                         height:400};

          // Instantiate and draw the chart for Sarah's pizza.
          var chart = new google.visualization.PieChart(document.getElementById('Sarah_chart_div'));
          chart.draw(data, options);
        }
        
        function drawVisualization1() {
            // Some raw data (not necessarily accurate)
            var data1 = google.visualization.arrayToDataTable([
             ['Month', 'Nombre de D�p�t','Tendance de nombre de D�p�t','Nombre de fois de virement �mis', 'Tendance de nombre de virement �mis', 'Nombre de fois de virement re�ue','Tendance de nombre de virement re�ue'],
             ['<%=FiveMonthBefore.getYear()%><%=FiveMonthBefore.getMonth()%>', <%=nd6%>,  <%=nd6%>,  <%=nve6%>,  <%=nve6%>,    <%=nvr6%>,  <%=nvr6%>],
             ['<%=FourMonthBefore.getYear()%><%=FourMonthBefore.getMonth()%>',  <%=nd5%>,  <%=nd5%>,  <%=nve5%>,  <%=nve5%>,    <%=nvr5%>,  <%=nvr5%>],
             ['<%=ThreeMonthBefore.getYear()%><%=ThreeMonthBefore.getMonth()%>',  <%=nd4%>,  <%=nd4%>,  <%=nve4%>,  <%=nve4%>,    <%=nvr4%>,  <%=nvr4%>],
             ['<%=TwoMonthBefore.getYear()%><%=TwoMonthBefore.getMonth()%>',  <%=nd3%>,  <%=nd3%>,  <%=nve3%>,  <%=nve3%>,    <%=nvr3%>,  <%=nvr3%>],
             ['<%=OneMonthBefore.getYear()%><%=OneMonthBefore.getMonth()%>',  <%=nd2%>,  <%=nd2%>,  <%=nve2%>,  <%=nve2%>,  <%=nvr2%>,    <%=nvr2%>],
             ['<%=ThisMonth.getYear()%><%=ThisMonth.getMonth()%>',  <%=nd1%>,  <%=nd1%>,  <%=nve1%>,   <%=nve1%>,    <%=nvr1%>,    <%=nvr1%>]
          ]);

        var options1 = {
          title : 'Situation du nombre de virement',
          width:650,
          height:400,
          vAxis: {title: 'Nombre de fois'},
          hAxis: {title: 'Mois'},
          seriesType: 'bars',
          series: {1: {type: 'line'}, 3:{type: 'line'}, 5:{type: 'line'}}
         
        };

        var chart1 = new google.visualization.ComboChart(document.getElementById('chart_div1'));
        chart1.draw(data1, options1);
      }

       
       
       
        
  //=============================================================================================================================
	  
       
      
     // Draw the pie chart for the Anthony's pizza when Charts is loaded.
       
        
        // Callback that draws the pie chart for Anthony's pizza.
        function drawAnthonyChart() {

          // Create the data table for Anthony's pizza.
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'Topping');
          data.addColumn('number', 'Slices');
          data.addRows([
        	['Montant de D�p�t (Euro)', <%=sd%>],
            ['Montant de virement �mis (Euro)', <%=se%>],
            ['Montant de virement re�ue (Euro)', <%=sr%>]
          ]);

          // Set options for Anthony's pie chart.
          var options = {title:'Situation du montant de virement',
                         width:450,
                         height:400};

          // Instantiate and draw the chart for Anthony's pizza.
          var chart = new google.visualization.PieChart(document.getElementById('Anthony_chart_div'));
          chart.draw(data, options);
        }
        
        function drawVisualization() {
          // Some raw data (not necessarily accurate)
          var data = google.visualization.arrayToDataTable([
           ['Month', 'D�p�t', 'Tendance de D�p�t','Virement �mis', 'Tendance de virement �mis', 'Virement re�ue','Tendance de virement re�ue'],
           ['<%=FiveMonthBefore.getYear()%><%=FiveMonthBefore.getMonth()%>', <%=md6%>, <%=md6%>, <%=ve6%>,      <%=ve6%>,   <%=vr6%>,  <%=vr6%>],
           ['<%=FourMonthBefore.getYear()%><%=FourMonthBefore.getMonth()%>', <%=md5%>, <%=md5%>, <%=ve5%>,      <%=ve5%>,   <%=vr5%>,  <%=vr5%>],
           ['<%=ThreeMonthBefore.getYear()%><%=ThreeMonthBefore.getMonth()%>', <%=md4%>, <%=md4%>, <%=ve4%>,      <%=ve4%>,   <%=vr4%>,  <%=vr4%>],
           ['<%=TwoMonthBefore.getYear()%><%=TwoMonthBefore.getMonth()%>',  <%=md3%>, <%=md3%>, <%=ve3%>,      <%=ve3%>,   <%=vr3%>,  <%=vr3%>],
           ['<%=OneMonthBefore.getYear()%><%=OneMonthBefore.getMonth()%>', <%=md2%>, <%=md2%>, <%=ve2%>,      <%=ve2%>,   <%=vr2%>,  <%=vr2%>],
           ['<%=ThisMonth.getYear()%><%=ThisMonth.getMonth()%>',  <%=md1%>, <%=md1%>, <%=ve1%>,  <%=ve1%>,   <%=vr1%>,   <%=vr1%>]
        ]);

      var options = {
        title : 'Situation du  montant de virement',
        width:650,
        height:400,
        vAxis: {title: 'Montant (Euro)'},
        hAxis: {title: 'Mois'},
        seriesType: 'bars',
        series: {1: {type: 'line'}, 3:{type: 'line'}, 5:{type: 'line'}}
      };

      var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
      chart.draw(data, options);
    }
        
        
        
     
    </script>
           	
    </section>
     <%} %>  
      
        
</body>
</html>
              