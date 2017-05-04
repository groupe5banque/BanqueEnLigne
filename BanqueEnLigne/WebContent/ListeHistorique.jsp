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
	String IdClient="0";
	if((String)session.getAttribute("IdClient")!=null)
	{
	IdClient = (String)session.getAttribute("IdClient");
	}
    String TypeH = (String)session.getAttribute("TypeH");
    System.out.println("Session récupéré:"+TypeH);
	ZoneId z = ZoneId.systemDefault();
	LocalDate today = LocalDate.now( z );
	LocalDate TwoMonthBefore = today.minusMonths(2); 
	LocalDate OneMonthBefore = today.minusMonths(1);
	LocalDate ThisMonth = today;
	Date datebefore3 = Date.valueOf(TwoMonthBefore);
	Date datebefore2 = Date.valueOf(OneMonthBefore);
	Date datebefore1 = Date.valueOf(ThisMonth);
	
    //System.out.println(datebefore.toString());
	HistoriqueDAO hd = new HistoriqueDAO();
    ClientDAO cd = new ClientDAO();
    CompteDAO cpd = new CompteDAO();
    
    //TypeH="2017";
    ArrayList<Historique> lh = hd.getAnneeHistorique(Integer.parseInt(TypeH),Integer.parseInt(IdClient));//Integer.parseInt(TypeH)
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
         
         double md12=0;
         double md11=0;
         double md10=0;
         double md9=0;
         double md8=0;
         double md7=0;
         double md6=0;
         double md5=0;
         double md4=0;
         double md3=0;
         double md2=0;
         double md1=0;
         
         double ve12=0;
         double ve11=0;
         double ve10=0;
         double ve9=0;
         double ve8=0;
         double ve7=0;
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
         double vr7=0;
         double vr8=0;
         double vr9=0;
         double vr10=0;
         double vr11=0;
         double vr12=0;
         
         int nve12=0;
         int nvr12=0;
         
         int nve11=0;
         int nvr11=0;
         
         int nve10=0;
         int nvr10=0;
         
         int nve9=0;
         int nvr9=0;
         
         int nve8=0;
         int nvr8=0;
         
         int nve7=0;
         int nvr7=0;
         
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
         
         int nd1=0;
         int nd2=0;
         int nd3=0;
         int nd4=0;
         int nd5=0;
         int nd6=0;
         int nd7=0;
         int nd8=0;
         int nd9=0;
         int nd10=0;
         int nd11=0;
         int nd12=0;
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
      <div id="top-menu" class="container-fluid active">
          <a class="navbar-brand" href="#">BIENVENUE SUR VOTRE ESPACE MANAGER</a>
          <ul class="nav navbar-nav">        
     
                    
              <li class="dropdown movable">
                  <a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><span class="caret"></span><span
						class="fa fa-3x fa-child"></span></a>
                  <ul class="dropdown-menu" role="menu">
                      <li> <a><span class="fa fa-user"></span> Bienvenue ${sessionScope.client.nomClient} </a></li>
                      <li class="divider"></li>
                      <li><a href="#"><span
								class="fa fa-power-off"></span> Déconnexion</a></li>
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
            <div class="link"><i class="fa fa-lg fa-user"></i>Actualités<i class="fa fa-chevron-down"></i></div>
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
    <section class="content-inner">
  <%
   if(llh.size()==0)
   {%>
	<H3>IL n'y a pas d'historique dans cette année.</H1>    
  <%
  }
   else{
  %>  
        <h3 class="text-center"> Reporting sur les historiques en <%=TypeH%></h3>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
       
      
       
      <h4> Situation globale:</h4>
       <!--Table and divs that hold the pie charts-->
    <table class="columns">
      <tr>
        <td><div id="Sarah_chart_div" style="title:'Situation du montant de virement',width:550, height:800"></div></td>
        <td><div id="Anthony_chart_div" style="title:'Situation du montant de virement',width:550, height:800"></div></td>
      </tr>
    </table>
       
        <div id="chart_div" style="border: 1px solid #ccc"></div>
        <br>
        <div id="chart_div1" style="border: 1px solid #ccc"></div>
        <br>
        <!--Table and divs that hold the pie charts-->
    <h4>Répartition du virement émis  sur les 3 type de compte:</h3>
    <table class="columns">
      <tr>
      <%if(ee==0&&ec==0&&et==0){ %>  
        <td><div id="ETN_chart_div"  style="border: 1px solid #ccc"></td>     
        <td><div id="ETM_chart_div"  style="border: 1px solid #ccc"></td>
      <%}else{%>
      <td>Il n'y pas de virement émis dans les trois mois précédents</td>
      <%}%>
      </tr>  
    </table>  
    <br>
    
    <!--Table and divs that hold the pie charts-->
    <h4>Répartition du virement reçue sur les 3 type de compte:</h3>
    <table class="columns">
      <tr>  
      <%if(re==0&&rc==0&&rt==0){ %> 
        <td><div id="RTN_chart_div"  style="border: 1px solid #ccc"></td>
        <td><div id="RTM_chart_div"  style="border: 1px solid #ccc"></td>
       <%}else{%>
      <td>Il n'y pas de virement reçue dans les trois mois précédents</td>
      <%}%>
      </tr>  
    </table>
    <br>
    <!--Table and divs that hold the pie charts-->
    <h4>Répartition du dépôt sur les 3 type de compte:</h3>
    <table class="columns">
      <tr>  
      <%if(de==0&&dc==0&&dt==0){ %> 
        <td><div id="DTN_chart_div"  style="border: 1px solid #ccc"></td>
        <td><div id="DTM_chart_div" style="border: 1px solid #ccc"></td>
      </tr>  
      <%}else{%>
      <td>Il n'y pas de dépôt dans les trois mois précédents</td>
      <%}%>
    </table>
    <br>
     
        
        <button onclick="Afficher()">Afficher/Cacher les historiques</button>
        <br>
        <br>
        <div id="table_div" style="title:'La liste des historiques'"></div>
        <br>
       <script> 
       <c:forEach var = "h" items = "${llh}">
       <c:choose>   
       <c:when test="${(!h.getNature().equals('Dépôt'))}">
      
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
      <c:when test="${(!h.getNature().equals('Dépôt'))}">
      
      
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
      <c:when test="${(!h.getNature().equals('Dépôt'))}">
      
      
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
      <c:when test="${(!h.getNature().equals('Dépôt'))}">
      
      
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
      
   <%//================================================================================================
      
       if(llh.get(t).getDate().getMonth()+1 == 1)
       {   
           System.out.println("Three month before\n");
    	   System.out.println(lh.get(t).getDate().getMonth());

    	   if(!llh.get(t).getNature().equals("Dépôt"))
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
       
       if(llh.get(t).getDate().getMonth()+1 == 2)
       {   
           System.out.println("Two month before\n");
    	   System.out.println(lh.get(t).getDate().getMonth());

    	   if(!llh.get(t).getNature().equals("Dépôt"))
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
       
       if(llh.get(t).getDate().getMonth()+1 == 3)
       {
    	   System.out.println("One month before\n");
    	   System.out.println(lh.get(t).getDate().getMonth()+1);

    	   if(!llh.get(t).getNature().equals("Dépôt"))
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
       
       if(llh.get(t).getDate().getMonth()+1 == 4)
       {
    	   System.out.println("This month\n");
    	   System.out.println(lh.get(t).getDate().getMonth());
    	   System.out.println(ThisMonth.getMonthValue());
    	   
    	   if(!llh.get(t).getNature().equals("Dépôt"))
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
       
       if(llh.get(t).getDate().getMonth()+1 == 5)
       {
    	   System.out.println("This month\n");
    	   System.out.println(lh.get(t).getDate().getMonth());
    	   System.out.println(ThisMonth.getMonthValue());
    	   
    	   if(!llh.get(t).getNature().equals("Dépôt"))
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
       
       if(llh.get(t).getDate().getMonth()+1 == 6)
       {
    	   System.out.println("This month\n");
    	   System.out.println(lh.get(t).getDate().getMonth());
    	   System.out.println(ThisMonth.getMonthValue());

    	   if(!llh.get(t).getNature().equals("Dépôt"))
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
       
       if(llh.get(t).getDate().getMonth()+1 == 7)
       {
    	   System.out.println("This month\n");
    	   System.out.println(lh.get(t).getDate().getMonth());
    	   System.out.println(ThisMonth.getMonthValue());

    	   if(!llh.get(t).getNature().equals("Dépôt"))
      	  {
    	   if(llh.get(t).getDebit()==0)
    	   {
    		   vr7=vr7+llh.get(t).getCredit();
    		   nvr7=nvr7+1;
    	   }
    	   else{
    		   ve7=ve7+llh.get(t).getDebit();
    		   nve7=nve7+1;
    	   }
      	}
           else
    	   {
    		   nd7=nd7+1;
    		   md7=md7+llh.get(t).getCredit();
    		   System.out.println("Montant de depot7:"+md7);
    	   }
       }
       
       if(llh.get(t).getDate().getMonth()+1 == 8)
       {
    	   System.out.println("This month\n");
    	   System.out.println(lh.get(t).getDate().getMonth());
    	   System.out.println(ThisMonth.getMonthValue());

    	   if(!llh.get(t).getNature().equals("Dépôt"))
      	  {
    	   if(llh.get(t).getDebit()==0)
    	   {
    		   vr8=vr8+llh.get(t).getCredit();
    		   nvr8=nvr8+1;
    	   }
    	   else{
    		   ve8=ve8+llh.get(t).getDebit();
    		   nve8=nve8+1;
    	   }
      	}
           else
    	   {
    		   nd8=nd8+1;
    		   md8=md8+llh.get(t).getCredit();
    		   System.out.println("Montant de depot8:"+md8);
    	   }
       }
       
       if(llh.get(t).getDate().getMonth()+1 == 9)
       {
    	   System.out.println("This month\n");
    	   System.out.println(lh.get(t).getDate().getMonth());
    	   System.out.println(ThisMonth.getMonthValue());

    	   if(!llh.get(t).getNature().equals("Dépôt"))
      	  {
    	   if(llh.get(t).getDebit()==0)
    	   {
    		   vr9=vr9+llh.get(t).getCredit();
    		   nvr8=nvr8+1;
    	   }
    	   else{
    		   ve9=ve9+llh.get(t).getDebit();
    		   nve9=nve9+1;
    	   }
      	}
           else
    	   {
    		   nd9=nd9+1;
    		   md9=md9+llh.get(t).getCredit();
    		   System.out.println("Montant de depot9:"+md9);
    	   }
       }
       
       if(llh.get(t).getDate().getMonth()+1 == 10)
       {
    	   System.out.println("This month\n");
    	   System.out.println(lh.get(t).getDate().getMonth());
    	   System.out.println(ThisMonth.getMonthValue());

    	   if(!llh.get(t).getNature().equals("Dépôt"))
      	  {
    	   if(llh.get(t).getDebit()==0)
    	   {
    		   vr10=vr10+llh.get(t).getCredit();
    		   nvr10=nvr10+1;
    	   }
    	   else{
    		   ve10=ve10+llh.get(t).getDebit();
    		   nve10=nve10+1;
    	   }
      	}
           else
    	   {
    		   nd10=nd10+1;
    		   md10=md10+llh.get(t).getCredit();
    		   System.out.println("Montant de depot10:"+md10);
    	   }
       }
       
       if(llh.get(t).getDate().getMonth()+1 == 11)
       {
    	   System.out.println("This month\n");
    	   System.out.println(lh.get(t).getDate().getMonth());
    	   System.out.println(ThisMonth.getMonthValue());

    	   if(!llh.get(t).getNature().equals("Dépôt"))
      	  {
    	   if(llh.get(t).getDebit()==0)
    	   {
    		   vr11=vr11+llh.get(t).getCredit();
    		   nvr11=nvr11+1;
    	   }
    	   else{
    		   ve11=ve11+llh.get(t).getDebit();
    		   nve11=nve11+1;
    	   }
      	}
           else
    	   {
    		   nd11=nd11+1;
    		   md11=md11+llh.get(t).getCredit();
    		   System.out.println("Montant de depot11:"+md11);
    	   }
       }
       
       if(llh.get(t).getDate().getMonth()+1 == 12)
       {
    	   System.out.println("This month\n");
    	   System.out.println(lh.get(t).getDate().getMonth());
    	   System.out.println(ThisMonth.getMonthValue());

    	   if(!llh.get(t).getNature().equals("Dépôt"))
      	  {
    	   if(llh.get(t).getDebit()==0)
    	   {
    		   vr12=vr12+llh.get(t).getCredit();
    		   nvr12=nvr12+1;
    	   }
    	   else{
    		   ve12=ve12+llh.get(t).getDebit();
    		   nve12=nve12+1;
    	   }
      	}
           else
    	   {
    		   nd12=nd12+1;
    		   md12=md12+llh.get(t).getCredit();
    		   System.out.println("Montant de depot12:"+md12);
    	   }
       }
       
       %>
       <% t=t+1;%>
       
      </c:forEach>
    
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
        	  ['Nombre de virement émis du compte épargne', <%=ee%>], 
            ['Nombre de virement émis du compte courant', <%=ec%>],
            ['Nombre de virement émis du compte titre', <%=et%>]
          ]);

          // Set options for Sarah's pie chart.
          var options = {title:'Répartition du nombre de Nombre de virement émis',
                         width:550,
                         height:400};

          // Instantiate and draw the chart for Sarah's pizza.
          var chart = new google.visualization.PieChart(document.getElementById('ETN_chart_div'));
          chart.draw(data, options);
        }
      
      function drawETMChart() {
          var data = google.visualization.arrayToDataTable([
            ['Montant de virement émis du compte épargne', 'Type de compte'],
            ['Montant de virement émis du compte épargne',     <%=mee%>],
            ['Montant de virement émis du compte courant',      <%=mec%>],
            ['Montant de virement émis du compte titre',  <%=met%>]
          ]);

          var options = {
            title: 'Répartition du montant de virement émis',
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
        	  ['Nombre de virement reçue du compte épargne', <%=re%>], 
            ['Nombre de virement reçue du compte courant', <%=rc%>],
            ['Nombre de virement reçue du compte titre', <%=rt%>]
          ]);

          // Set options for Sarah's pie chart.
          var options = {title:'Répartition du nombre de virement reçue',
                         width:550,
                         height:400};

          // Instantiate and draw the chart for Sarah's pizza.
          var chart = new google.visualization.PieChart(document.getElementById('RTN_chart_div'));
          chart.draw(data, options);
        }
      
      function drawRTMChart() {
          var data = google.visualization.arrayToDataTable([
            ['Montant', 'Type de transaction'],
            ['Montant de virement reçue du compte épargne',     <%=mre%>],
            ['Montant de virement reçue du compte courant',      <%=mrc%>],
            ['Montant de virement reçue du compte titre',  <%=mrt%>]
          ]);

          var options = {
            title: 'Répartition du montant de virement',
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
        	  ['Nombre Dépôt du compte épargne', <%=de%>], 
            ['Nombre Dépôt du compte courant', <%=dc%>],
            ['Nombre Dépôt du compte titre', <%=dt%>]
          ]);

          // Set options for Sarah's pie chart.
          var options = {title:'Répartition du nombre de dépôt',
                         width:550,
                         height:400};

          // Instantiate and draw the chart for Sarah's pizza.
          var chart = new google.visualization.PieChart(document.getElementById('DTN_chart_div'));
          chart.draw(data, options);
        }
      
      function drawDTMChart() {
          var data = google.visualization.arrayToDataTable([
            ['Montant', 'Type de transaction'],
            ['Montant Dépôt du compte épargne',     <%=mde%>],
            ['Montant Dépôt du compte courant',      <%=mdc%>],
            ['Montant Dépôt du compte titre',  <%=mdt%>]
          ]);

          var options = {
            title: 'Répartition du montant de dépôt',
            pieHole: 0.4,
            width:550,
            height:400
          };

          var chart = new google.visualization.PieChart(document.getElementById('DTM_chart_div'));
          chart.draw(data, options);
        }
	
	    	
//=============================================================================================================================
	
        // Load Charts and the corechart package.
        google.charts.load('current', {'packages':['corechart', 'table']});

        // Draw the pie chart for Sarah's pizza when Charts is loaded.
        google.charts.setOnLoadCallback(drawSarahChart);
        google.charts.setOnLoadCallback(drawVisualization);
     // Draw the pie chart for the Anthony's pizza when Charts is loaded.
        google.charts.setOnLoadCallback(drawAnthonyChart);
        google.charts.setOnLoadCallback(drawVisualization1);
        //google.charts.load('current', {'packages':['table']});
          google.charts.setOnLoadCallback(drawTable); 
          
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
       
        
        

        // Callback that draws the pie chart for Sarah's pizza.
        function drawSarahChart() {

          // Create the data table for Sarah's pizza.
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'Topping');
          data.addColumn('number', 'Slices');
          data.addRows([
        	['Nombre de Dépôt', <%=d%>],  
            ['Nombre de virement émis', <%=e%>],
            ['Nombre de virement reçue', <%=r%>]
          ]);

          // Set options for Sarah's pie chart.
          var options = {title:'Situation du nombre de virement en <%=TypeH%>', width:550,height:400};

          // Instantiate and draw the chart for Sarah's pizza.
          var chart = new google.visualization.PieChart(document.getElementById('Sarah_chart_div'));
          chart.draw(data, options);
        }
        
        
        
        function drawVisualization1() {
            // Some raw data (not necessarily accurate)
            var data1 = google.visualization.arrayToDataTable([
             ['Month', 'Nombre de Dépôt', 'Tendance de nombre de Dépôt','Nombre de fois de virement émis', 'Tendance de nombre de virement émis', 'Nombre de fois de virement reçue','Tendance de nombre de virement reçue'],
             ['JANVIER',  <%=nd1%>, <%=nd1%>, <%=nve1%>,  <%=nve1%>,    <%=nvr1%>,  <%=nvr1%>],
             ['FEVRIER',  <%=nd2%>, <%=nd2%>, <%=nve2%>,  <%=nve2%>,  <%=nvr2%>,    <%=nvr2%>],
             ['MARS',  <%=nd3%>, <%=nd3%>, <%=nve3%>,   <%=nve3%>,    <%=nvr3%>,    <%=nvr3%>],
             ['AVRIL',  <%=nd4%>, <%=nd4%>, <%=nve4%>,   <%=nve4%>,    <%=nvr4%>,    <%=nvr4%>],
             ['MAI',   <%=nd5%>, <%=nd5%>, <%=nve5%>,   <%=nve5%>,    <%=nvr5%>,    <%=nvr5%>],
             ['JUIN',   <%=nd6%>, <%=nd6%>, <%=nve6%>,   <%=nve6%>,    <%=nvr6%>,    <%=nvr6%>],
             ['JUILLET',  <%=nd7%>, <%=nd7%>, <%=nve7%>,   <%=nve7%>,    <%=nvr7%>,    <%=nvr7%>],
             ['AOÛT',   <%=nd8%>, <%=nd8%>, <%=nve8%>,   <%=nve8%>,    <%=nvr8%>,    <%=nvr8%>],
             ['SEPTEMBRE',   <%=nd9%>, <%=nd9%>, <%=nve9%>,   <%=nve9%>,    <%=nvr9%>,    <%=nvr9%>],
             ['OCTOBRE',   <%=nd10%>, <%=nd10%>, <%=nve10%>,   <%=nve10%>,    <%=nvr10%>,    <%=nvr10%>],
             ['NOVEMBRE',   <%=nd11%>, <%=nd11%>, <%=nve11%>,   <%=nve11%>,    <%=nvr11%>,    <%=nvr11%>],
             ['DECEMBRE',   <%=nd12%>, <%=nd12%>, <%=nve12%>,   <%=nve12%>,    <%=nvr12%>,    <%=nvr12%>]
          ]);

        var options1 = {   
          title : 'Situation du nombre de virement en <%=TypeH%>',
          width:1100,
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
	  
      
        
        // Callback that draws the pie chart for Anthony's pizza.
        function drawAnthonyChart() {

          // Create the data table for Anthony's pizza.
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'Topping');
          data.addColumn('number', 'Slices');
          data.addRows([
        	['Montant du Dépôt (Euro)', <%=sd%>],
            ['Montant de virement émis (Euro)', <%=se%>],
            ['Montant de virement reçue (Euro)', <%=sr%>]
          ]);

          // Set options for Anthony's pie chart.
          var options = {title:'Situation du montant de virement en <%=TypeH%>',width:550,height:400
                         };

          // Instantiate and draw the chart for Anthony's pizza.
          var chart = new google.visualization.PieChart(document.getElementById('Anthony_chart_div'));
          chart.draw(data, options);
        }
        
        function drawVisualization() {
          // Some raw data (not necessarily accurate)
          var data = google.visualization.arrayToDataTable([
           ['Month', 'Dépôt','Tendance de dépôt','Montant de virement émis', 'Tendance de montant de virement émis', 'Montant de virement reçue',' Tendance de montant de virement reçue'],
           ['JANVIER',  <%=md1%>, <%=md1%>, <%=ve1%>,  <%=ve1%>,    <%=vr1%>,  <%=vr1%>],
           ['FEVRIER', <%=md2%>, <%=md2%>,  <%=ve2%>,  <%=ve2%>,  <%=vr2%>,    <%=vr2%>],
           ['MARS',  <%=md3%>, <%=md3%>, <%=ve3%>,   <%=ve3%>,    <%=vr3%>,    <%=vr3%>],
           ['AVRIL',  <%=md4%>, <%=md4%>,  <%=ve4%>,   <%=ve4%>,    <%=vr4%>,    <%=vr4%>],
           ['MAI',  <%=md5%>, <%=md5%>, <%=ve5%>,   <%=ve5%>,    <%=vr5%>,    <%=vr5%>],
           ['JUIN',  <%=md6%>, <%=md6%>, <%=ve6%>,   <%=ve6%>,    <%=vr6%>,    <%=vr6%>],
           ['JUILLET',  <%=md7%>, <%=md7%>, <%=ve7%>,   <%=ve7%>,    <%=vr7%>,    <%=vr7%>],
           ['AOÛT',  <%=md8%>, <%=md8%>, <%=ve8%>,   <%=ve8%>,    <%=vr8%>,    <%=vr8%>],
           ['SEPTEMBRE',  <%=md9%>, <%=md9%>, <%=ve9%>,   <%=ve9%>,    <%=vr9%>,    <%=vr9%>],
           ['OCTOBRE',  <%=md10%>, <%=md10%>, <%=ve10%>,   <%=ve10%>,    <%=vr10%>,    <%=vr10%>],
           ['NOVEMBRE',  <%=md11%>, <%=md11%>, <%=ve11%>,   <%=ve11%>,    <%=vr11%>,    <%=vr11%>],
           ['DECEMBRE',   <%=md12%>, <%=md12%>,<%=ve12%>,   <%=ve12%>,    <%=vr12%>,    <%=vr12%>]
        ]);

      var options = {
        title : 'Situation du  montant de virement en <%=TypeH%>',
        width:1100,
        height:400,
        vAxis: {title: 'Montant (Euro)'},
        hAxis: {title: 'Mois'},
        seriesType: 'bars',
        series: {1: {type: 'line'}, 3:{type: 'line'}, 5:{type: 'line'}}
      };

      var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
      chart.draw(data, options);
    }
        
        
        
     
   //============================================================================================================================ 
        
        
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
          <%  int n=0;%> 
          
          
          <c:forEach var = "h" items = "${llh}">   
          
          
          data.addRows([
            ['<%=NomPrenom.get(n)%>','<c:out value="${h.getIdClient_historique()}"/>', '<c:out value="${h.getIdCompte_historique()}"/>', '<%=NumeroCompte.get(n)%>', '<c:out value="${h.getDate()}"/>', '<c:out value="${h.getNature()}"/>', '<c:out value="${h.getCredit()}"/>', '<c:out value="${h.getDebit()}"/>']
        ]);
          <% System.out.println(llh.get(n).getIdClient_historique());%>   
           <% n=n+1;%>
          </c:forEach>
          
          var table = new google.visualization.Table(document.getElementById('table_div'));
          table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});   
       }
         
   </script>
    
    
           	
    </section>
     <%} %> 
      
        
</body>
</html>
              