<%-- 
    Document   : header3
    Created on : 23 Apr, 2016, 3:29:17 PM
    Author     : HP PC
--%>
 <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">AdsBookelet</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="myhome.do">Home</a></li>
      <li><a href="categoryypage.do">Post Free Ads</a></li> 
    </ul>
     <ul class="nav navbar-nav navbar-right">
      <% if(session.getAttribute("username") == null ) { %>
<!--      <li><a href="registerLink.do"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>-->
      <li><a href="adminloginLink.do"><span class="glyphicon glyphicon-log-in"></span>Admin Login</a></li>
      <% } else { %>
      <li>
          <p class="navbar-text"> Hello, <strong><%=session.getAttribute("username")%></strong>
            <span class="glyphicon glyphicon-user"></span>
          </p>
      </li>
      <li><a href="logout.do">Logout</a></li>
      <% } %>
    </ul>
  </div>
</nav>
    <% String message1 = (String)session.getAttribute("flash_message"); %>
      <% if(message1!= null){ %>
<div class="alert alert-success disappear">
  <strong>Success!</strong> <%= message1 %>
</div>
<% session.removeAttribute("flash_message"); } %>

