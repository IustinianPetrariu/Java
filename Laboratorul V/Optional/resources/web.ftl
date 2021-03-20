<html>
<head>
</head>

<body>
     <h1> ${title} </h1>
     <ul>
        <#list catalogs as catalog>
         <li> ${catalog_index + 1}. ${catalog.name} . ${catalog.path} </li>
         </#list>
       </ul>
</body>
</html>