<html>
    <?php include "includes/head.php"; 

    $id_museo = $_GET['id'];
    $query = "SELECT * FROM musei WHERE id_museo = $id_museo";
    $museo = $db->query($query);

    print_r($museo);
    if($museo->num_rows == 0)
    {
        print "Al momento nessun museo ha aderito a questa associazione.";
    }
    else
    {
        $id_museo = museo['id_museo'];
        $nome = museo['nome'];
        $descrizione = museo['descrizione'];
        $costo = museo['costo'];
        if(museo['aperto'] == 't')
            $aperto = "aperto";
        else
            $aperto = "chiuso";
        $apertura = museo['apertura'];
        $chiusura = museo['chiusura'];
        $immagine = museo['immagine'];
    }
    ?>
    <body>
        <?php include "includes/header.php";
        
        print
        "<div class='col-md-4' style='float:left'>
            <div class='mu-featured-tours-single'>
                <img src='assets/images/$immagine' alt='img'>
                <div class='mu-featured-tours-single-info'>
                    <h3>$nome</h3>
                    <h4>Apertura: $apertura-$chiusura</h4>
                    <h4>Aperto: $aperto</h4>
                    <span class='mu-price-tag'>prezzo: $costo €</span>
                    <p>$descrizione</p>                 
                </div>
            </div>
        </div>
        <section id='mu-contact' style='float:left'>
            <div class='container'>
                <div class='row'>
                    <div class='col-md-12'>
                        <div class='mu-contact-area'>
                            <h2>Pagamento</h2>                
                            <div class='mu-contact-content'>
                                <div class='row'>
                                    <div class='col-md-12'>
                                        <div class='mu-contact-form-area'>
                                            <div id='form-messages'></div>
                                                <form id='ajax-contact' method='post' action='mailer.php' class='mu-contact-form'>
                                                    <div class='row'>
                                                        <div class='col-md-6'>
                                                            <div class='form-group'>                
                                                                <input type='text' class='form-control' placeholder='Codice_carta' id='name' name='codice_carta' required>
                                                            </div>
                                                        </div>

                                                        <div class='col-md-6'>
                                                            <div class='form-group'>                
                                                                    <input type='email' class='form-control' placeholder='Cvv' id='cvv' name='cvv' required>
                                                            </div>    
                                                        </div>          
                                                    </div>

                                                   <div class='form-group'>                
                                                           <input type='text' class='form-control' placeholder='Data Scadenza' id='subject' name='data_scadenza' required>
                                                   </div>

                                                   <button type='submit' class='mu-send-msg-btn'><span>Acquista</span></button>
                                               </form>
                                           </div>
                                       </div>
                                   </div>
                               </div>
                           <!-- End Contact Content -->
                           </div>
                       </div>
                   </div>
               </div>
           </section>;
        
        ?>
    </body>";


