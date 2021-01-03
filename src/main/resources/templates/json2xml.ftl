<#-- @ftlvariable name="JsonUtil" type="de.consol.jbl.util.JsonUtil" -->
<#assign body = JsonUtil.jsonToMap(input)>
<?xml version="1.0" encoding="UTF-8"?>
<data>
    <employee>
        <id>${body.data.employee.empid}</id>
        <name>${body.data.employee.empname}</name>
     	<location>${body.data.employee.location}</location>
    </employee>
</data>