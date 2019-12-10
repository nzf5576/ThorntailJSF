<%-- 
    Document   : twilio_callback
    Created on : Oct 7, 2014, 10:54:28 PM
    Author     : mike
--%>

<%@page contentType="text/xml" %>
<Response>
    <Say voice="woman">Connecting you to the help desk.</Say>
    <Dial><%= request.getParameter("From") %></Dial>
</Response>