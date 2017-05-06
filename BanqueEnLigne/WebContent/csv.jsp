<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.ByteArrayInputStream" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="javax.servlet.ServletOutputStream" %>

<%@ page import="dto.*" %>
<%@ page import="dao.*" %>

<%
  	/*
			@param: This code expects "csv_data1" to contain the data to download as csv
			@param: In "file_name" its an optional param for naming the .csv file
		 */
		//String csv_string1 = request.getParameter("csv_data1");
		//String csv_string2 = request.getParameter("csv_data2");
					
		String file_name = request.getParameter("file_name");
		//if(file_name.length() == 0) file_name = "Releves.csv";
		
		response.setContentType("application/csv");
		response.setHeader("content-disposition","filename="+file_name); // Filename
		
		//PrintWriter outxx = response.getWriter();
        //BufferedWriter bw = new BufferedWriter(outxx);
        
        
		//outxx.append(csv_string1);
		//outxx.append(',');
		//outxx.append(csv_string2);
		//outxx.flush();
		//outxx.close();
		
		  	    
   	    //response.setContentType("application/csv");
		//response.setHeader("Content-disposition", "attachment; filename=Releves.csv");

		//PrintWriter outx = response.getWriter();
		
	    ServletOutputStream outx = response.getOutputStream();
	    
		//ExportTrainee exptrainee = new ExportTrainee();
		StringBuffer sb;
		InputStream in;
		
		

		//public StringBuffer exportcsv(String[] str)
	//{
		StringBuffer writer = new StringBuffer();
		//Session session = HibernateUtil.currentSession();	

		//for (int i = 0; i < str.length; i++) 
		//{	
			CsvReleveDAO dao1 = new CsvReleveDAO();
			
			List<Releve> releves = dao1.FindReleveDuMois(1,2,4);
			
			//List<Releve> ltrainee = (List<Releve>)session.createCriteria(Releve.class).add(Restrictions.like("id", Integer.parseInt(str[i]))).list();
			
			if (releves != null)
			{
				for(Releve tr: (ArrayList<Releve>)releves)
				{		
					String solde= Float.toString(tr.getSoldeClient_Releve());
					
					writer.append(solde.replace("\n", "\t"));
					
					writer.append(";");
					
					String credit= Integer.toString(tr.getCredit());
					
					writer.append(credit.replace("\n", "\t"));
					
					writer.append(";");
					
					String debit= Integer.toString(tr.getDebit());
					
					writer.append(debit.replace("\n", "\t"));
					
					writer.append(";");
				
					String idClient_Releve= Integer.toString(tr.getIdClient_Releve());
					
					writer.append(idClient_Releve.replace("\n", "\t"));
					
					writer.append(";");
					
					String idCompte_Releve= Integer.toString(tr.getIdCompte_Releve());
					
					writer.append(idCompte_Releve.replace("\n", "\t"));
					
					writer.append(";");
					 
					writer.append(tr.getNature().replace("\n", "\t"));
					
					writer.append(";");
					
					if (tr.getDate() != null)
					{
						DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
						String birth = date.format(tr.getDate());

						writer.append(birth);
					}
					else
						writer.append("");
					
					writer.append(";");
					
					
					writer.append("\n");	
				}
			}
		//}
		//writer.setLength(0);

		
	//}
		
		//sb = exptrainee.exportcsv(request.getParameter("trainees").split(":"));
		
			sb= writer;
			
			in = new ByteArrayInputStream(sb.toString().getBytes("ISO-8859-1"));


		byte[] outxputByte = new byte[4096];
		int len = 0;
		while((len = in.read(outxputByte, 0, 4096)) != -1)
		{
			outx.write(outxputByte, 0, len);
		}
		in.close();

  	    outx.flush();
		outx.close(); 
		
		
%>