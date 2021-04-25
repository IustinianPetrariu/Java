<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
     <h1> ${title} </h1>
      <table>
      <tbody>
      <tr>
           <th> nr.crt </th>
           <th> dao.MovieJDBC Title </th>
           <th> dao.MovieJDBC Score </th>
      </tr>
             <#list movies as movie>
              <tr>
                <td> ${movie_index + 1} </td>
                 <td> ${movie.title}  </td>
                 <td> ${movie.score} </td>
              </tr>
              </#list>
            </tbody>
       </table>
</body>
</html>