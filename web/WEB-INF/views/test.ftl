<html>
<head><title>FreeMarker Hello World</title>

<body>
<form name="user" action="hello" method="post">
    Id: <input type="text" name="id" /> <br/>
    Name: <input type="text" name="name" /> <br/>
    City: <input type="text" name="city" />       <br/>
    <input type="submit" value="Save" />
</form>

<table class="datatable">
    <tr>
        <th>ID</th>  <th>Name</th> <th>City</th>
    </tr>
    <#list employees as employee>
    <tr>
        <td>${employee.id}</td> <td>${employee.name}</td><td>${employee.city}</td>
    </tr>
    </#list>
</table>
</body>
</html>