package chatsocket;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 *
 * @author degri
 */
public class UIChat extends javax.swing.JFrame {
    private String inputText; //frase da inviare
    private String nomeUtente; //nome utente
    private InetAddress addr;
    private Socket socket=null;
    private BufferedReader in=null;
    private PrintWriter out=null;
    private static UIChat frame; //frame principale
 
    public UIChat() throws IOException {
        initComponents();
        Input.addMouseListener(new MouseAdapter(){ //quando clicco sul textfield la scritta "Scrivi..." viene eliminata
            @Override
            public void mouseClicked(MouseEvent e){
                Input.setText("");
            }
        });
        
        Action action = new AbstractAction() //azione per il tasto invio nella chat
        {
            @Override
            public void actionPerformed(ActionEvent e){
                inputText = Input.getText();
                Input.setText("");
                try {
                    mandaMsg(inputText);
                } catch (IOException ex) {
                    Logger.getLogger(UIChat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        Input.addActionListener(action);
        
        InserisciNome.setVisible(true); //frame che permette di inserire il nome
        InserisciNome.setSize(1000, 650);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InserisciNome = new javax.swing.JFrame();
        label1 = new java.awt.Label();
        Ok = new java.awt.Button();
        nomeInput = new java.awt.TextField();
        indirizzoInput = new java.awt.TextField();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();
        Invio = new javax.swing.JButton();
        Input = new java.awt.TextField();

        InserisciNome.setLocation(new java.awt.Point(500, 300));

        label1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        label1.setText("Inserisci l'ip del server");

        Ok.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Ok.setLabel("Ok");
        Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkActionPerformed(evt);
            }
        });

        nomeInput.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        indirizzoInput.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        label2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        label2.setText("Inserisci il tuo nome");

        label3.setFont(new java.awt.Font("Microsoft Himalaya", 3, 48)); // NOI18N
        label3.setText("CHAT DI GRUPPO");

        javax.swing.GroupLayout InserisciNomeLayout = new javax.swing.GroupLayout(InserisciNome.getContentPane());
        InserisciNome.getContentPane().setLayout(InserisciNomeLayout);
        InserisciNomeLayout.setHorizontalGroup(
            InserisciNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InserisciNomeLayout.createSequentialGroup()
                .addGroup(InserisciNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InserisciNomeLayout.createSequentialGroup()
                        .addGap(439, 439, 439)
                        .addComponent(Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InserisciNomeLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(InserisciNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InserisciNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(indirizzoInput, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 165, Short.MAX_VALUE))
            .addGroup(InserisciNomeLayout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        InserisciNomeLayout.setVerticalGroup(
            InserisciNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InserisciNomeLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addGroup(InserisciNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(indirizzoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(InserisciNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addComponent(Ok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 300));

        TextArea.setEditable(false);
        TextArea.setColumns(20);
        TextArea.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        TextArea.setRows(5);
        jScrollPane1.setViewportView(TextArea);

        Invio.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Invio.setText("Invio");
        Invio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InvioActionPerformed(evt);
            }
        });

        Input.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Input.setText("Scrivi...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Input, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Invio, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Invio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Input, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InvioActionPerformed
        inputText = Input.getText(); //invio il messaggio e pulisco la textfield
        Input.setText("");
        try {
            mandaMsg(inputText);
        } catch (IOException ex) {
            Logger.getLogger(UIChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_InvioActionPerformed

    private void OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkActionPerformed
        nomeUtente = nomeInput.getText(); //imposto il nome e l'indirizzo e avanzo alla prossima finestra (chat)
        try {
            addr = InetAddress.getByName(indirizzoInput.getText());
        } catch (UnknownHostException ex) {
            Logger.getLogger(UIChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        InserisciNome.setVisible(false);
        frame.setVisible(true);
        
        try {
            socket = new Socket(addr, 12345);
            
            OutputStreamWriter osw = new OutputStreamWriter( socket.getOutputStream());
            BufferedWriter bw = new BufferedWriter(osw);
            out = new PrintWriter(bw, true);
        } catch (IOException ex) {
            Logger.getLogger(UIChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ThreadAscolto R1 = null;
        try {
            R1 = new ThreadAscolto("Thread", TextArea, indirizzoInput.getText()); //thread che ascolta echo dal server
        } catch (UnknownHostException ex) {
            Logger.getLogger(UIChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        R1.start();
    }//GEN-LAST:event_OkActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    frame = new UIChat();
                    frame.setVisible(false);
                } catch (IOException ex) {
                    Logger.getLogger(UIChat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void mandaMsg(String msg) throws IOException{
        out.println("[" + nomeUtente + "]: " + msg); //stampo messaggio sull'outputstreamwriter
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextField Input;
    private javax.swing.JFrame InserisciNome;
    private javax.swing.JButton Invio;
    private java.awt.Button Ok;
    private javax.swing.JTextArea TextArea;
    private java.awt.TextField indirizzoInput;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.TextField nomeInput;
    // End of variables declaration//GEN-END:variables
}

class ThreadAscolto implements Runnable {
    private Thread t;
    private String nome;
    
    private InetAddress addr;
    private Socket socket=null;
    private BufferedReader in=null;
    
    private javax.swing.JTextArea TextArea;

    ThreadAscolto(String nome, javax.swing.JTextArea area, String indirizzo) throws UnknownHostException {
       this.TextArea = area;
       this.nome = nome;
       this.addr = InetAddress.getByName(indirizzo);
    }

    public void run() {
        try {
            socket = new Socket(addr, 12345);
            InputStreamReader isr = new InputStreamReader( socket.getInputStream());
            in = new BufferedReader(isr);
            
            while(true){
                TextArea.append("\n" + in.readLine());
            }
        } catch (IOException ex) {
            Logger.getLogger(ThreadAscolto.class.getName()).log(Level.SEVERE, null, ex);
            try {
                in.close();
                socket.close();
            } catch (IOException ex1) {
                Logger.getLogger(ThreadAscolto.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public void start () {
       if (t == null) {
          t = new Thread (this, nome);
          t.start ();
       }
    }
}