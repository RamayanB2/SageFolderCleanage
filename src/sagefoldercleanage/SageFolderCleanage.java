/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sagefoldercleanage;

import java.io.File;
import java.nio.file.*;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Ramayan Bellatrix
 */
public class SageFolderCleanage {
    
    static String path,dir1,dir2,dir3,dir4,dir5;
    static String file1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        
        //Pega pasta my documents NO WINDOWS
        JFileChooser fr = new JFileChooser();
        FileSystemView fw = fr.getFileSystemView();
        //System.out.println(fw.getDefaultDirectory());//Mydocuments

        
        File f = new File("");
        path = fw.getDefaultDirectory()+"\\SAGE2_Media";//Caminho do pasta sage2-media aqui
        dir1 = "\\sessions";//subdiretorio para rodar o codigo abaixo
        dir2 = "\\videos";//subdiretorio para rodar o codigo abaixo
        dir3 = "\\images";//subdiretorio para rodar o codigo abaixo
        dir4 = "\\notes";//subdiretorio para rodar o codigo abaixo
        dir5 = "\\pdfs";//subdiretorio para rodar o codigo abaixo
        file1 = "\\passwd.json";//arquivo de password
        
        //Usar path+ dir1 , path+dir 2 assim por diante
        
        int reply = JOptionPane.showConfirmDialog(null, "Olá! A sua sessão do sage já foi encerrada... \n Por questões de privacidade, gostaria de deletar todos os dados compartilhados na sessão anterior? \n (Imagens,Pdfs,Notas,etc...) \n\n Obs: A senha (Meeting Id) para a sessão também será deletada, se aceitar.", "Auxiliar de Limpeza do Sage", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
           deletePassword();
           cleanAllFiles();
           JOptionPane.showMessageDialog(null, "Sessão limpa com sucesso. \n Obrigado!");
        }
        else {
           System.exit(0);
        }                
        

    }
    
    public static void deletePassword(){
        try{
        Files.deleteIfExists(Paths.get(file1));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro");
        }
    }
    
    public static void cleanAllFiles(){
        try{           
        Arrays.stream(new File(path+dir1).listFiles()).forEach(File::delete);
        Arrays.stream(new File(path+dir2).listFiles()).forEach(File::delete);
        Arrays.stream(new File(path+dir3).listFiles()).forEach(File::delete);
        Arrays.stream(new File(path+dir4).listFiles()).forEach(File::delete);
        Arrays.stream(new File(path+dir5).listFiles()).forEach(File::delete);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Arquivos não deletados.\n"
                    + "O jar não está no diretório correto.\n"
                    + "Favor posicionar o jar na pasta SAGE2_MEDIA."+ "\n Diretório atual: "+ path+" .");
        }
    }
}
