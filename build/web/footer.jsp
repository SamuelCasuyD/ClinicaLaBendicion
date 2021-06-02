
            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
            <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.24/datatables.min.js"></script>
            <script>
                $(function () {
                    $('[data-toggle="tooltip"]').tooltip();
                });
            </script>
            <script>
                $(document).ready(function() {
                    $('#example').DataTable( {
                        "lengthMenu": [[10, 25, 50, 75, 100, -1], [10, 25, 50, 75, 100, "Todas"]],
                        "language":{
                            sLengthMenu: "Mostrar _MENU_ registros",
                            sInfo: "Registros del _START_ al _END_ | Total: _TOTAL_",
                            sInfoEmpty: "Mostrando registros del 0 al 0 de un total de 0 registros",
                            sInfoFiltered: "(filtrado de un total de _MAX_ registros)",
                            sSearch: "Buscar:",
                            sLoadingRecords: "Cargando...",
                            oPaginate: {
                                sFirst: "Primero",
                                sLast: "Último",
                                sNext: "Siguiente",
                                sPrevious: "Anterior"
                            }                 
                        }         

                    } );
                } );
            </script>
            <script>
    $(document).ready(function() {
        function bs_input_file() {
            $(".input-file").before(
                function() {
                    if ( ! $(this).prev().hasClass('input-ghost') ) {
                        var element = $("<input type='file' class='input-ghost' style='visibility:hidden; height:0'>");
                        element.attr("name",$(this).attr("name"));
                        element.change(function(){
                            element.next(element).find('input').val((element.val()).split('\\').pop());
                        });
                        $(this).find("button.btn-choose").click(function(){
                            element.click();
                        });
                        $(this).find("button.btn-reset").click(function(){
                            element.val(null);
                            $(this).parents(".input-file").find('input').val('');
                        });
                        $(this).find('input').css("cursor","pointer");
                        $(this).find('input').mousedown(function() {
                            $(this).parents('.input-file').prev().click();
                            return false;
                        });
                        return element;
                    }
                }
            );
        }
         
        bs_input_file();
         
        $("#uploadBtn").on("click", function() {
            var url = "demo";
            var form = $("#sampleUploadFrm")[0];
            var data = new FormData(form);
            /* var data = {};
            data['key1'] = 'value1';
            data['key2'] = 'value2'; */
            $.ajax({
                type : "POST",
                encType : "multipart/form-data",
                url : url,
                cache : false,
                processData : false,
                contentType : false,
                data : data,
                success : function(msg) {
                    var response = JSON.parse(msg);
                    var status = response.status;
                    if (status == 1) {
                        alert("File has been uploaded successfully");
                    } else {
                        alert("Couldn't upload file");
                    }
                },
                error : function(msg) {
                    alert("Couldn't upload file");
                }
            });
        });
    });
</script>

<script>
//Get the button
var mybutton = document.getElementById("myBtn");

// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    mybutton.style.display = "block";
  } else {
    mybutton.style.display = "none";
  }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
}
</script>
        </div>
    </body>
</html>
