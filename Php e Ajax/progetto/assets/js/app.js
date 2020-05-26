$(document.body).on("click","#invia_c",function()
{
    $("#risposta").hide();
    messaggio = $('#messaggio_c').val();
    mail = $('#mail_c').val();
    
    querystring = "mail="+mail+"&messaggio="+messaggio+"&act=invia";
    $.ajax({
            type: 'POST',
            url: "parts/contattaci.php",
            data: querystring,
            success: function(data)
            {
                $('#messaggio_c').val("");
                $('#mail_c').val("");
                if(data == "KO")
                {
                    $("#risposta").text("Errore nell'invio del messaggio.");
                    $("#risposta").show();
                }
                else
                {
                    $("#risposta").show();
                    $("#risposta").text("Messaggio inviato con successo!");
                }
            }
    });
});