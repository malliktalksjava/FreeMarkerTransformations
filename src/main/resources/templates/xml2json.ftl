<#assign data = xml['child::node()']>
{
    "employee": {
        "id": ${data.employee.id},
        "name": "${data.employee.name}",
        "location": "${data.employee.location}"
    }
}