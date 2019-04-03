<%@ page language="java" contentType="application/vnd.ms-excel; charset=gbk"
    pageEncoding="gbk"%>
<%@page import="java.util.List, com.bao.domain.Student,com.bao.dao.IStudentDao,
			com.bao.dao.impl.StudentDaoJdbcImpl"%>

 

<%
   //response.setHeader("Content-disposition","inline; filename=videos.xls");
   response.setHeader("Content-disposition","attachment; filename=data.xls");
   //以上这行设定传送到前端浏览器时的档名为data.xls
   //就是靠这一行，让前端浏览器以为接收到一个excel档 
%>


<%
	IStudentDao stuDao = new StudentDaoJdbcImpl();
	List<Student> allStu = stuDao.findAll();
%>


<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel"
xmlns="http://www.w3.org/TR/REC-html40">

<head>
<meta http-equiv=Content-Type content="text/html; charset=gb2312">
<meta name=ProgId content=Excel.Sheet>
<meta name=Generator content="Microsoft Excel 11">
<link rel=File-List href="学生数据Excel模板.files/filelist.xml">
<link rel=Edit-Time-Data href="学生数据Excel模板.files/editdata.mso">
<link rel=OLE-Object-Data href="学生数据Excel模板.files/oledata.mso">
<!--[if gte mso 9]><xml>
 <o:DocumentProperties>
  <o:Author>ChinaUser</o:Author>
  <o:LastAuthor>ChinaUser</o:LastAuthor>
  <o:Created>2017-01-09T02:19:14Z</o:Created>
  <o:LastSaved>2017-01-09T03:24:41Z</o:LastSaved>
  <o:Company>China</o:Company>
  <o:Version>11.6360</o:Version>
 </o:DocumentProperties>
</xml><![endif]-->
<style>
<!--table
	{mso-displayed-decimal-separator:"\.";
	mso-displayed-thousand-separator:"\,";}
@page
	{margin:1.0in .75in 1.0in .75in;
	mso-header-margin:.5in;
	mso-footer-margin:.5in;}
tr
	{mso-height-source:auto;
	mso-ruby-visibility:none;}
col
	{mso-width-source:auto;
	mso-ruby-visibility:none;}
br
	{mso-data-placement:same-cell;}
.style0
	{mso-number-format:General;
	text-align:general;
	vertical-align:middle;
	white-space:nowrap;
	mso-rotate:0;
	mso-background-source:auto;
	mso-pattern:auto;
	color:windowtext;
	font-size:12.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	border:none;
	mso-protection:locked visible;
	mso-style-name:常规;
	mso-style-id:0;}
td
	{mso-style-parent:style0;
	padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:12.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-number-format:General;
	text-align:general;
	vertical-align:middle;
	border:none;
	mso-background-source:auto;
	mso-pattern:auto;
	mso-protection:locked visible;
	white-space:nowrap;
	mso-rotate:0;}
.xl24
	{mso-style-parent:style0;
	text-align:center;}
.xl25
	{mso-style-parent:style0;
	font-weight:700;
	text-align:center;}
ruby
	{ruby-align:left;}
rt
	{color:windowtext;
	font-size:9.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-char-type:none;
	display:none;}
-->
</style>
<!--[if gte mso 9]><xml>
 <x:ExcelWorkbook>
  <x:ExcelWorksheets>
   <x:ExcelWorksheet>
    <x:Name>导出的学生数据</x:Name>
    <x:WorksheetOptions>
     <x:DefaultRowHeight>285</x:DefaultRowHeight>
     <x:Print>
      <x:ValidPrinterInfo/>
      <x:PaperSizeIndex>9</x:PaperSizeIndex>
      <x:HorizontalResolution>600</x:HorizontalResolution>
      <x:VerticalResolution>600</x:VerticalResolution>
     </x:Print>
     <x:Selected/>
     <x:Panes>
      <x:Pane>
       <x:Number>3</x:Number>
       <x:ActiveRow>5</x:ActiveRow>
       <x:ActiveCol>2</x:ActiveCol>
      </x:Pane>
     </x:Panes>
     <x:ProtectContents>False</x:ProtectContents>
     <x:ProtectObjects>False</x:ProtectObjects>
     <x:ProtectScenarios>False</x:ProtectScenarios>
    </x:WorksheetOptions>
   </x:ExcelWorksheet>
  </x:ExcelWorksheets>
  <x:WindowHeight>12660</x:WindowHeight>
  <x:WindowWidth>16035</x:WindowWidth>
  <x:WindowTopX>0</x:WindowTopX>
  <x:WindowTopY>90</x:WindowTopY>
  <x:ProtectStructure>False</x:ProtectStructure>
  <x:ProtectWindows>False</x:ProtectWindows>
 </x:ExcelWorkbook>
</xml><![endif]-->
</head>

<body link=blue vlink=purple>

<table x:str border=0 cellpadding=0 cellspacing=0 width=336 style='border-collapse:
 collapse;table-layout:fixed;width:252pt'>
 <col width=72 span=2 style='width:54pt'>
 <col width=120 style='mso-width-source:userset;mso-width-alt:3840;width:90pt'>
 <col width=72 style='width:54pt'>
 <tr height=19 style='height:14.25pt'>
  <td height=19 class=xl25 width=72 style='height:14.25pt;width:54pt'>学号</td>
  <td class=xl25 width=72 style='width:54pt'>姓名</td>
  <td class=xl25 width=120 style='width:90pt'>班级</td>
  <td class=xl25 width=72 style='width:54pt'>成绩</td>
 </tr>
 
 <%
 	for(Student s:allStu){
 %>
	 <tr height=19 style='height:14.25pt'>
	  <td height=19 class=xl24 style='height:14.25pt' x:num><%=s.getId() %></td>
	  <td class=xl24><%=s.getName() %></td>
	  <td class=xl24><%=s.getMyclass() %></td>
	  <td class=xl24 x:num><%=s.getScore() %></td>
	 </tr>
 <%
 	}//for语句的结束
 %>
 

 <![if supportMisalignedColumns]>
 <tr height=0 style='display:none'>
  <td width=72 style='width:54pt'></td>
  <td width=72 style='width:54pt'></td>
  <td width=120 style='width:90pt'></td>
  <td width=72 style='width:54pt'></td>
 </tr>
 <![endif]>
</table>

</body>

</html>