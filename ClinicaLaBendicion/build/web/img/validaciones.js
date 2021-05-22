            $(function() {
                $("#username").change(function() {
// ajax                
                var usuario = $("#username").val();
                console.log(usuario);
                    $.ajax({
                        type: "POST",
                        url: "ajax.jsp",
                        data: {username: $("#username").val()}
                    })
                            .done(function(msg) {
                                if (msg === "si")
                                {
                                    alert("El nombre (" + $("#username").val() + ") ya existe.");
                                }
                            });
                });
            });