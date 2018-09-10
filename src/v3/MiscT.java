package v3;


import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicch
 */
public class MiscT extends javax.swing.JFrame {
    ResultSet rs=null;
    Connection Conn=null;
    PreparedStatement pst=null;
    Statement smt;
    
    String lvv,Mats,Tem,cs;
    String fn,Sn,FmrS,Hob,AsCla,AsDom,Patt,Phot,cLA,dRM,mrt;
    String StdCont,Rsdn,Gnam,Gco,GresCou,AsSr,AsCb,AsCl,tbl;
    String lv,nmm,Fom;        String slSbj,lst,fd,cl,Trrm,ths,Varr,lst2,lst3;
    String fcll, SBJ, Trm, tama, spa;
    int sbjPck,pmp,pmf;
    int chh=0,bioo=0,phys=0,Goeg=0,cree=0,hsty=0,agrc=0,busns=0,mrk;
    int Regg,Kp,Indx,Cnt1,cnt2,Dbrth,Gcon,Rg;
    byte[]Stdimg=null;
    String Mt,En,Kw,Ce,Bl,Ph,Go,Ht,Cr,Al,Bu,TbChs;
    Calendar cc=new GregorianCalendar();
    int ya=cc.get(Calendar.YEAR);
    int mwr=cc.get(Calendar.MONTH)+1;
    int mth,eng,ksw,chm,bio,phy,geo,cre,hist,biz,agr;
    String Tbll, mck,Str,Fm;
    int F1n,F1s,F1e,F1w,F2n,F2s,F2e,F2w,F3n,F3s,F3e,F3w,F4n,F4s,F4e,F4w,Fmm;
    //String tam=null,TY,yer;
    String fg,sg,gi;
    String snmcls,snmstr,snmsbj;
    int hr,lr,hop;
    String cmnt,frgd,sbgd,grd,ClStr,Makk;
    String fromas;
    int jmpmath,jmpeng,jmpkiswa,jmpchem,jmpbio,jmpphy,jmpgeo,jmpcre,jmphist,jmpagr,jmpbus;
    int jmpmathc,jmpengc,jmpkiswac,jmpchemc,jmpbioc,jmpphyc,jmpgeoc,jmpcrec,jmphistc,jmpagrc,jmpbusc;

    /**
     * Creates new form Misc
     */
    public MiscT() {
        initComponents();
        Conn=(Connection) Dbsv2.InitDb();
        this.setIconImage(new ImageIcon(getClass().getResource("/Imgy/gretext.gif")).getImage());
        Dimension dim=getToolkit().getScreenSize();
        int jframWidth=this.getSize().width;
        int jframHeight=this.getSize().height;
        int locationX=(dim.width-jframWidth)/2;
        int locationY=(dim.height-jframHeight)/2;
        this.setLocation(locationX, locationY);
        //Slideh();
        /*Dabase dcc=new Dabase();
        dcc.setVisible(Boolean.TRUE);*/
        Mk();
        setTitle("Testing v3.0");
        setExtendedState(MAXIMIZED_BOTH);
    }
    
    private void Slideh(){
        ImageIcon img1;
            img1=new ImageIcon(getClass().getResource("/Imgy/polarbear1.jpg"));
            Image Sd1=img1.getImage().getScaledInstance(SlCont.getWidth(),SlCont.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon im1=new ImageIcon(Sd1);
            SlCont.setIcon(im1);
        /*new Thread(){
            public void run(){
                ImageIcon img1,img2,img3,img4;
                try {
                    int tara=0;
                    while (Boolean.TRUE) {
                        switch (tara){
                        case 0:
                            img1=new ImageIcon(getClass().getResource("/Imgy/polarbear1.jpg"));
                            Image Sd1=img1.getImage().getScaledInstance(SlCont.getWidth(),SlCont.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon im1=new ImageIcon(Sd1);
                            SlCont.setIcon(im1);
                            tara=1;
                            Thread.sleep(3000);
                            break;
                        case 1:
                            img2=new ImageIcon(getClass().getResource("/Imgy/polarbear2.jpg"));
                            Image Sd=img2.getImage().getScaledInstance(SlCont.getWidth(),SlCont.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon im2=new ImageIcon(Sd);
                            SlCont.setIcon(im2);
                            tara=2;
                            Thread.sleep(3000);
                            break;
                        case 2:
                            img3=new ImageIcon(getClass().getResource("/Imgy/polarbear3.jpg"));
                            Image Sd3=img3.getImage().getScaledInstance(SlCont.getWidth(),SlCont.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon im3=new ImageIcon(Sd3);
                            SlCont.setIcon(im3);
                            tara=3;
                            Thread.sleep(3000);
                            break;
                        case 3:
                            img4=new ImageIcon(getClass().getResource("/Imgy/polarbear4.jpg"));
                            Image Sd4=img4.getImage().getScaledInstance(SlCont.getWidth(),SlCont.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon im4=new ImageIcon(Sd4);
                            SlCont.setIcon(im4);
                            tara=0;
                            Thread.sleep(3000);
                            break;
                    }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e+"\nImage Error");
                }
            }
        }.start();*/
    }
    
    private void Mk(){
        Admin.setVisible(Boolean.FALSE);
        AddMrk.setVisible(Boolean.FALSE);
        NwStd.setVisible(Boolean.FALSE);
        Conff.setVisible(Boolean.FALSE);
        Repo.setVisible(Boolean.FALSE);
        Mainn.setVisible(Boolean.FALSE);
        Senr.setVisible(Boolean.FALSE);
        SnrTblAd.setVisible(Boolean.FALSE);
        StrNxt.setEnabled(Boolean.FALSE);
        MarkUp();
        Droop();
        Inst();
        Lopa();
        Frez();
        Desp();
        Cou();
        IinCon();
        Star();
        Slepa();
    }
    
    private void Lopa(){
        for (int i = 1995; i < 2010; i++) {
            String lvv=String.valueOf(i);
            Canos2.addItem(lvv);
        }
        KcGrad2.setEnabled(Boolean.FALSE);
        
    }
    
    private void Uppa(){
        int kc=Integer.parseInt(KcMrk2.getText().toString());
        if (kc<200) {
            KcGrad2.setSelectedIndex(3);
        }
        else if (kc<250 && kc >200) {
            KcGrad2.setSelectedIndex(2);
        }
        else if (kc<320 && kc >250) {
            KcGrad2.setSelectedIndex(1);
        }
        else if (kc >320) {
            KcGrad2.setSelectedIndex(0);
        }
        else if (KcMrk2.getText().toString()==null) {
            KcGrad2.setSelectedIndex(4);
        }
        KcGrad2.setEnabled(Boolean.FALSE);
    }
    
    private void Hoppa(){
        try {
            String sql="SELECT `Reg_No` FROM `tbl_Students` ORDER BY `Count` DESC LIMIT 1";
            pst= (PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if (rs.next()) {
                hop=rs.getInt("Reg_No")+1;
                RgNo.setEnabled(Boolean.FALSE);
                RgNo.setText(String.valueOf(hop));
            }
        } catch (Exception e) {
        }
    }
    
    private void IkiaP2() {
        try {
            lv="UPDATE `tbl_Placer` SET "+slSbj+"=1 WHERE `Reg_No`=?";
            pst=(PreparedStatement) Conn.prepareStatement(lv);
            pst.setInt(1, Integer.parseInt(RgNo.getText()));
            pst.executeUpdate();
            
            //JOptionPane.showMessageDialog(null, "Succesfully Updated Tbl Place "+slSbj);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nError Updating Tbl Place "+slSbj);
        }
    }

    private void Cutta(){
        if (NWstdStChm.isSelected()) {
            chh=chh+1;
            slSbj="Chemistry";
            IkiaP2();
        }
        if (NWstdStBio.isSelected()) {
            bioo=bioo+1;
            slSbj="Biology ";
            IkiaP2();
        }
        if (NWstdStPhy.isSelected()) {
            phys=phys+1;
            slSbj="Physics ";
            IkiaP2();;
        }
        if (NWstdStGeo.isSelected()) {
            Goeg=Goeg+1;
            slSbj="Geography ";
            IkiaP2();
        }
        if (NWstdStCRE.isSelected()) {
            cree=cree+1;
            slSbj="CRE ";
            IkiaP2();
        }
        if (NWstdStHist.isSelected()) {
            hsty=hsty+1;
            slSbj="History ";
            IkiaP2();
        }
        if (NWstdStAgr.isSelected()) {
            agrc=agrc+1;
            slSbj="Agriculture ";
            IkiaP2();
        }
        if (NWstdStBus.isSelected()) {
            busns=busns+1;
            slSbj="Business";
            IkiaP2();
        }
    }
    
    private  void Nm(){
        try {
                String sql="SELECT `Test` FROM `tbl_Tests` ORDER BY `Count` DESC LIMIT 1";
                pst= (PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if (rs.next()) {
                    lst=rs.getString("Test");
                }
                
                String sql2="SELECT `Test` FROM `tbl_Tests` WHERE Count=(SELECT MAX(Count)-1 FROM `tbl_Tests`) ";
                pst= (PreparedStatement) Conn.prepareStatement(sql2);
                rs=pst.executeQuery();
                if (rs.next()) {
                    lst2=rs.getString("Test");
                }

                //Toolkit.getDefaultToolkit().beep();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nCurrent Exam Table Error");
            //Toolkit.getDefaultToolkit().beep();
        }
        
        eXA.setEnabled(Boolean.FALSE);
        eXA.setText(lst);
    }
    
    private void Inst(){
        int tt=cc.get(Calendar.YEAR);
        
        for (int i = 2015; i < 2025; i++) {
            lvv=String.valueOf(i);
            //YBx.addItem(lvv);
            YBx.addItem(String.valueOf(tt));
        }
        
        YBx.setEnabled(Boolean.FALSE);
        Cbf1.setEnabled(false);
        Cbf2.setEnabled(false);
        Cbf3.setEnabled(false);
        Cbf4.setEnabled(false);
        
    }
    
    private void Star(){
        Nm();        
        //2017_End_Term_Term2
        String Lst1=lst;
        
        try {
            String Gtt="CAT";
            String Gtt1="Mid";
            String Gtt2="End";

            String Gtt3="Term1";
            String Gtt4="Term2";
            String Gtt5="Term3";

                Pattern r = Pattern.compile(Gtt);
                Pattern r1 = Pattern.compile(Gtt1);
                Pattern r2 = Pattern.compile(Gtt2);

                Pattern r3 = Pattern.compile(Gtt3);
                Pattern r4 = Pattern.compile(Gtt4);
                Pattern r5 = Pattern.compile(Gtt5);

                Matcher m = r.matcher(Lst1);
                Matcher m1 = r1.matcher(Lst1);
                Matcher m2 = r2.matcher(Lst1);

                Matcher m3 = r3.matcher(Lst1);
                Matcher m4 = r4.matcher(Lst1);
                Matcher m5 = r5.matcher(Lst1);

                if (m.find( )) {
                   ExxamTY.setSelectedIndex(0);
                   RepoEX.setSelectedIndex(0);
                   RepoEX1.setSelectedIndex(2);
                } 
                else if (m1.find( )) {
                   ExxamTY.setSelectedIndex(1);
                   RepoEX.setSelectedIndex(1);
                   RepoEX1.setSelectedIndex(1);
                }
                else if (m2.find( )) {
                   ExxamTY.setSelectedIndex(2);
                   RepoEX.setSelectedIndex(2);
                   RepoEX1.setSelectedIndex(2);
                }
                else {
                   ExxamTY.setSelectedIndex(3);
                }

                if (m3.find( )) {
                   Tr1.setSelected(Boolean.TRUE);
                   RepoTrm1.setSelected(true);
                   RepoTrm4.setSelected(true);
                } 
                else if (m4.find( )) {
                   Tr2.setSelected(Boolean.TRUE);
                   RepoTrm2.setSelected(true);
                   RepoTrm5.setSelected(true);
                }
                else if (m5.find( )) {
                   Tr3.setSelected(Boolean.TRUE);
                   RepoTrm3.setSelected(true);
                   RepoTrm6.setSelected(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "NO Valid Table");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"Tables Mismatch");
        }
            ExxamTY.setEnabled(Boolean.FALSE);
            Tr1.setEnabled(Boolean.FALSE);
            Tr2.setEnabled(Boolean.FALSE);
            Tr3.setEnabled(Boolean.FALSE);
            RepoTrm3.setEnabled(Boolean.FALSE);
            RepoTrm2.setEnabled(Boolean.FALSE);
            RepoTrm1.setEnabled(Boolean.FALSE);
            RepoTrm4.setEnabled(Boolean.FALSE);
            RepoTrm5.setEnabled(Boolean.FALSE);
            RepoTrm6.setEnabled(Boolean.FALSE);
            RepoEX.setEnabled(false);
            RepoEX1.setEnabled(false);
    }
    
    private void Maka(){
        int tt=cc.get(Calendar.YEAR);
        String yer=String.valueOf(tt);
        String TY=ExxamTY.getSelectedItem().toString();
        String tam=null;
        if (Tr1.isSelected()) {
            tam="Term1";
        }
        if (Tr2.isSelected()) {
            tam="Term2";
        }
        if (Tr3.isSelected()) {
            tam="Term3";
        }
        
        fd=yer+"_"+TY+"_"+tam;
    }
    
    private void Putta(){
        Maka();
        String Cls=null;
        if (Cbf1.isSelected()) {
            Cls="Form1";
        }
        if (Cbf2.isSelected()) {
            Cls="Form2";
        }
        if (Cbf3.isSelected()) {
            Cls="Form3";
        }
        if (Cbf4.isSelected()) {
            Cls="Form4";
        }
        //JOptionPane.showMessageDialog(null, fd+"---Am The Table");
        try {
            String sql="SELECT Name,Class,Reg_No,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,CRE,History,Business,Agriculture FROM  "+fd+" WHERE `Class`='"+Cls+"' ";
            pst=(PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            Tsta.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nNo Such Table"+"\nPutta Erro");
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    private  void Setta(Double x,String j,int p){
        Nm();
        //Makr();
        String sqll="UPDATE `"+lst+"` SET "+j+"="+x+" WHERE Reg_No="+p+"";
        try {
            pst=(PreparedStatement) Conn.prepareStatement(sqll);
            pst.execute();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex+" +++Setta Error");
        }
    }
    
    private  void MarkUp(){
        for (int i = 2016; i < 2025; i++) {
            lvv=String.valueOf(i);
            YBx1.addItem(lvv);
        }
        Cbf5.setSelected(Boolean.TRUE);
        Cbf6.setSelected(Boolean.TRUE);
        Cbf7.setSelected(Boolean.TRUE);
        Cbf8.setSelected(Boolean.TRUE);
        Cbf5.setEnabled(Boolean.FALSE);
        Cbf6.setEnabled(Boolean.FALSE);
        Cbf7.setEnabled(Boolean.FALSE);
        Cbf8.setEnabled(Boolean.FALSE);
        F1Log.setText(null);
        F4Log.setText(null);
        F3Log.setText(null);
        F2Log.setText(null);
    }
    
    private void Droop(){
        if (Cbf5.isSelected()) {
            Mats="Form1";
        }else if (Cbf6.isSelected()) {
            Mats="Form2";
        }else if (Cbf7.isSelected()) {
            Mats="Form3";
        }else if (Cbf8.isSelected()) {
            Mats="Form4";
        }
    }
    
    private void Conf(){
        if (Tr4.isSelected()) {
            Tem="Term1";
        }
        else if (Tr5.isSelected()) {
            Tem="Term2";
        }
        else if (Tr6.isSelected()) {
            Tem="Term3";
        }
    }
    
    private void Filla(){
        try {
            //String sql="INSERT INTO `"+cs+"` (Name,Reg_No,Class)  SELECT Name,Reg_No,Class FROM tbl_Students WHERE `Class`='"+Mats+"'";
            String sql="INSERT INTO `"+cs+"` (Name,Reg_No,Class,Stream)  SELECT Name,Reg_No,Class,Stream FROM tbl_Students";
            smt=(Statement) Conn.prepareStatement(sql);
            //smt.executeUpdate(sql);
            pst = (PreparedStatement) Conn.prepareStatement(sql);
            pst.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nTable Already Exists");
        }
    }
    
    private void Lasta(){
        try {
            String sql="SELECT `Test` FROM `tbl_Tests` ORDER BY `Count` DESC LIMIT 1";
            pst= (PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if (rs.next()) {
                lst=rs.getString("Test");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nCurrent Exam Table Error");
            Toolkit.getDefaultToolkit().beep();
        }
        
        //cl=Classe.getSelectedItem().toString();
        cl=ClassLv.getSelectedItem().toString();
        
        if (cl=="Form 1") {
            tbl="Form1";
        }else if(cl=="Form 2"){
            tbl="Form2";
        }else if(cl=="Form 3"){
            tbl="Form3";
        }else if(cl=="Form 4"){
            tbl="Form4";
        }
    }
    
    private void Frez(){
        Trmm();
        Finda();
        ExamType.setEnabled(Boolean.FALSE);
        Terma.setEnabled(Boolean.FALSE);
        
        try {
            String sql="SELECT `Test` FROM `tbl_Tests` ";
            pst= (PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while (rs.next()) {
                String elm=rs.getString("Test");
                    String bd = "_";
                    String gd = "  ";
                    Pattern pt1 = Pattern.compile(bd);
                    Matcher m1 = pt1.matcher(elm); 
                    //elm = m1.replaceAll(gd);    
                Ex1Perf.addItem(elm);
                Ex2Perf.addItem(elm);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nCurrent Exam Table Error");
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    private void Trmm(){
        int mnt=cc.get(Calendar.MONTH)+1;
        if(mnt<5){
            Trrm="Term One";
            Terma.setSelectedIndex(00);
        }
        if(mnt>4 &&mnt<9){
            Trrm="Term Two";
            Terma.setSelectedIndex(01);
        }
        if(mnt>8 ){
            Trrm="Term Three";
            Terma.setSelectedIndex(02);
        }
    }
    
    private void Finda(){
        Lasta();
        String Lst1=lst;
        String Gtt="CAT";
        String Gtt1="Mid";
        String Gtt2="End";
        
            Pattern r = Pattern.compile(Gtt);
            Pattern r1 = Pattern.compile(Gtt1);
            Pattern r2 = Pattern.compile(Gtt2);
            
            Matcher m = r.matcher(Lst1);
            Matcher m1 = r1.matcher(Lst1);
            Matcher m2 = r2.matcher(Lst1);
            
            if (m.find( )) {
               ExamType.setSelectedIndex(0);
            } 
            else if (m1.find( )) {
               ExamType.setSelectedIndex(1);
            }
            else if (m2.find( )) {
               ExamType.setSelectedIndex(2);
            }
            else{
                JOptionPane.showMessageDialog(null, "Corrupted Search");
            }
        
    }
    
    private void Comp(){
        try {
            String sql="SELECT * FROM `"+TbChs+"` ORDER BY `Count` DESC LIMIT 1";
            pst= (PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if (rs.next()) {
                //Mt,En,Kw,Ce,Bl,Ph,Go,Ht,Cr,Al,Bu;
                Mt=rs.getString("Mathematics");
                En=rs.getString("English");
                Kw=rs.getString("Kiswahili");
                Ce=rs.getString("Chemistry");
                Bl=rs.getString("Biology");
                Ph=rs.getString("Physics");
                Go=rs.getString("Geography");
                Ht=rs.getString("History");
                Cr=rs.getString("CRE");
                Al=rs.getString("Agriculture");
                Bu=rs.getString("Business");
                //JOptionPane.showMessageDialog(null, Mt+En+Kw+Ce+Bl+Ph+Go+Ht+Cr+Al+Bu);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nMarks Parse Error");
            Toolkit.getDefaultToolkit().beep();
        }
        Tabler();   
    }
    
    private void Tabler(){
        int cur=SbjBox.getSelectedIndex();
        //Mt,En,Kw,Ce,Bl,Ph,Go,Ht,Cr,Al,Bu;
        if (cur==1) {
            mrk=Integer.valueOf(Mt);
        }
        if (cur==2) {
            mrk=Integer.valueOf(En);
        }
        if (cur==3) {
            mrk=Integer.valueOf(Kw);
        }
        if (cur==4) {
            mrk=Integer.valueOf(Ce);
        }
        if (cur==5) {
            mrk=Integer.valueOf(Bl);
        }
        if (cur==6) {
            mrk=Integer.valueOf(Ph);
        }
        if (cur==7) {
            mrk=Integer.valueOf(Go);
        }
        if (cur==8) {
            mrk=Integer.valueOf(Ht);
        }
        if (cur==9) {
            mrk=Integer.valueOf(Cr);
        }
        if (cur==10) {
            mrk=Integer.valueOf(Al);
        }
        if (cur==11) {
            mrk=Integer.valueOf(Bu);
        }
        //JOptionPane.showMessageDialog(null, Mt+En+Kw+Ce+Bl+Ph+Go+Ht+Cr+Al+Bu+"\n"+mrk);
        
    }
    
    private void Searc(){
        if (SrchConst.getSelectedIndex()==0) {
            Varr="Reg_No";
        }else if (SrchConst.getSelectedIndex()==1) {
            Varr="Name";
        }else if (SrchConst.getSelectedIndex()==2) {
            Varr="Class";
        }
        //String Crt=SrchConst.getSelectedItem().toString();
        //String Crt=Varr;
        String vl=ConsBox.getText().toString();
        try {               
                String Lv="SELECT  Name,Surname,Reg_No,KCPE,Class,Dorm,Parent,Residence,Contact  FROM `tbl_Students`  WHERE `"+Varr+"` LIKE '%"+vl+"%' ";
                pst=(PreparedStatement) Conn.prepareStatement(Lv);
                rs=pst.executeQuery();
                //while(rs.next()) { 
                    /*pst=conn.prepareStatement(Lv);
                    rs=pst.executeQuery();*/
                    ClVwTY.setModel(DbUtils.resultSetToTableModel(rs));
            //}   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\n");
        }
    }
    
    private void Setta(){        
        if (mwr<5) {
            Trm="Term 1";
            tama="Term1";
        }
        if (mwr<9 && mwr>4) {
            Trm="Term 2";
            tama="Term2";
        }
        if (mwr>8) {
            Trm="Term 3";
            tama="Term3";
        }
        
        spa=Trm+"-"+ths;
    }
    
    private void Desp(){
        try {
                String sql="SELECT `Test` FROM `tbl_Tests` ORDER BY `Count` DESC LIMIT 1 ";
                pst= (PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if (rs.next()) {
                    lst=rs.getString("Test");
                    TvwLst.addItem(lst);
                    GenTbl.addItem(lst);
                    uPtBL.addItem(lst);
                }
                Toolkit.getDefaultToolkit().beep();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nCurrent Exam Table Error");
                Toolkit.getDefaultToolkit().beep();
            }
        
        jLabel3.setEnabled(Boolean.FALSE);
        OtCom.setEnabled(Boolean.FALSE);
        //Classe.setEnabled(Boolean.FALSE);
        OtCom.setText(null);
        
        Trm1.setEnabled(Boolean.FALSE);
        Trm2.setEnabled(Boolean.FALSE);
        Trm3.setEnabled(Boolean.FALSE);
        Cts.setEnabled(Boolean.FALSE);
        Mts.setEnabled(Boolean.FALSE);
        Ets.setEnabled(Boolean.FALSE);
        
        GenTvw.setEnabled(Boolean.FALSE);
        TvwLst.setEnabled(Boolean.FALSE);
        ConnecView.setEnabled(false);
        uPtBL.setEnabled(Boolean.FALSE);
        GenTbl.setEnabled(Boolean.FALSE);
        jLabel3.setEnabled(true);
        RegAsBtn.setEnabled(false);
    }
    
    private void IinCon (){
        Integer ki=ConnecView.getSelectedIndex();
        new Thread(new Runnable(){
            public void run(){
                Socket ss=new Socket();
                InetSocketAddress add=new InetSocketAddress("www.google.com",80);
                try {
                    ss.connect(add,8080);
                    ConnecView.setSelectedIndex(0);
                } catch (Exception e) {
                    ConnecView.setSelectedIndex(1);
                }
            }
        }).start();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        
    }
    
    private void rEDA(){
        String Tbb=TvwLst.getSelectedItem().toString();
        try {
            FileWriter fw=new FileWriter(lst+".csv");
            String sql="SELECT * FROM `"+Tbb+"`";
            Statement stmt=(Statement) Conn.createStatement();
            rs=stmt.executeQuery(sql);
            String lista="Count,Name,Class,Reg_No,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,History,CRE,Business,Agriculture";
            //fw.append(lista+"\n");
            while (rs.next()) {                
                //fw.append(rs.getString(0));
                //fw.append(",");
                fw.append(rs.getString(1));
                fw.append(",");
                fw.append(rs.getString(2));
                fw.append(",");
                fw.append(rs.getString(3));
                fw.append(",");
                fw.append(rs.getString(4));;
                fw.append(",");
                fw.append(rs.getString(5));
                fw.append(",");
                fw.append(rs.getString(6));
                fw.append(",");
                fw.append(rs.getString(7));
                fw.append(",");
                fw.append(rs.getString(8));
                fw.append(",");
                fw.append(rs.getString(9));
                fw.append(",");
                fw.append(rs.getString(10));
                fw.append(",");
                fw.append(rs.getString(11));
                fw.append(",");
                fw.append(rs.getString(12));
                fw.append(",");
                fw.append(rs.getString(13));
                fw.append(",");
                fw.append(rs.getString(14));;
                fw.append(",");
                fw.append(rs.getString(15));
                //fw.append(",");
                fw.append("\n");
            }
            fw.flush();
            fw.close();
            JOptionPane.showMessageDialog(null, "Succesfully Parsed");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nNigga");
        }
    }
    
    private void Cou(){
        for (int i = 0; i < 31; i++) {
            int fct=i;
            ClassCatFM1.addItem(String.valueOf(fct));
            ClassCatPm1.addItem(String.valueOf(fct));
        }
        for (int i = 0; i < 101; i++) {
            int fct=i;
            ClassMidFM1.addItem(String.valueOf(fct));
            ClassMidPM1.addItem(String.valueOf(fct));
            
            ClassEndFM1.addItem(String.valueOf(fct));
            ClassEndPM1.addItem(String.valueOf(fct));
            Hrange.addItem(String.valueOf(i));
            Lrange.addItem(String.valueOf(i));
        }
        //ClassCatPm1
    }
    
    private void Slepa(){
        if(AddF1.isSelected()){
            AddF1N.setEnabled(true);
            AddF1S.setEnabled(true);
            AddF1W.setEnabled(true);
            AddF1E.setEnabled(true);
        }else{
            AddF1N.setEnabled(false);
            AddF1S.setEnabled(false);
            AddF1W.setEnabled(false);
            AddF1E.setEnabled(false);
        }
        
        if(AddF2.isSelected()){
            AddF2N.setEnabled(true);
            AddF2S.setEnabled(true);
            AddF2W.setEnabled(true);
            AddF2E.setEnabled(true);
        }else{
            AddF2N.setEnabled(false);
            AddF2S.setEnabled(false);
            AddF2W.setEnabled(false);
            AddF2E.setEnabled(false);
        }
        
        if(AddF3.isSelected()){
            AddF3N.setEnabled(true);
            AddF3S.setEnabled(true);
            AddF3W.setEnabled(true);
            AddF3E.setEnabled(true);
        }else{
            AddF3N.setEnabled(false);
            AddF3S.setEnabled(false);
            AddF3W.setEnabled(false);
            AddF3E.setEnabled(false);
        }
        
        if(AddF4.isSelected()){
            AddF4N.setEnabled(true);
            AddF4S.setEnabled(true);
            AddF4W.setEnabled(true);
            AddF4E.setEnabled(true);
        }else{
            AddF4N.setEnabled(false);
            AddF4S.setEnabled(false);
            AddF4W.setEnabled(false);
            AddF4E.setEnabled(false);
        }
    }
    
    private void Mng(){
        try {
            String Kret="UPDATE `tbl_ClassList` SET `"+Str+"`= 1 WHERE `Class`='"+Fm+"'";
            pst=(PreparedStatement) Conn.prepareStatement(Kret);
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex+"\nClass Variables Errors");
        }
    }
    
    private void Greda(){
        if (FormGrad.getSelectedIndex()==0) {
            frgd="Form1";
        }
        if (FormGrad.getSelectedIndex()==1) {
            frgd="Form2";
        }
        if (FormGrad.getSelectedIndex()==2) {
            frgd="Form3";
        }
        if (FormGrad.getSelectedIndex()==3) {
            frgd="Form4";
        }
        
        if (SubGrad.getSelectedIndex()==0) {
            sbgd="";
        }
        if (SubGrad.getSelectedIndex()==1) {
            sbgd="Mathematics";
        }
        if (SubGrad.getSelectedIndex()==2) {
            sbgd="English";
        }
        if (SubGrad.getSelectedIndex()==3) {
            sbgd="Kiswahili";
        }
        if (SubGrad.getSelectedIndex()==4) {
            sbgd="Chemistry";
        }
        if (SubGrad.getSelectedIndex()==5) {
            sbgd="Biology";
        }
        if (SubGrad.getSelectedIndex()==6) {
            sbgd="Physics";
        }
        if (SubGrad.getSelectedIndex()==7) {
            sbgd="Geography";
        }
        if (SubGrad.getSelectedIndex()==8) {
            sbgd="History";
        }
        if (SubGrad.getSelectedIndex()==9) {
            sbgd="CRE";
        }
        if (SubGrad.getSelectedIndex()==10) {
            sbgd="Agriculture";
        }
        if (SubGrad.getSelectedIndex()==11) {
            sbgd="Business";
        }
        
        if (GradIt.getSelectedIndex()==0) {
            grd="";
        }
        if (GradIt.getSelectedIndex()==1) {
            grd="A";
        }
        if (GradIt.getSelectedIndex()==2) {
            grd="A-";
        }
        if (GradIt.getSelectedIndex()==3) {
            grd="B+";
        }
        if (GradIt.getSelectedIndex()==4) {
            grd="B";
        }
        if (GradIt.getSelectedIndex()==5) {
            grd="B-";
        }
        if (GradIt.getSelectedIndex()==6) {
            grd="C+";
        }
        if (GradIt.getSelectedIndex()==7) {
            grd="C";
        }
        if (GradIt.getSelectedIndex()==8) {
            grd="C-";
        }
        if (GradIt.getSelectedIndex()==9) {
            grd="D+";
        }
        if (GradIt.getSelectedIndex()==10) {
            grd="D";
        }
        if (GradIt.getSelectedIndex()==11) {
            grd="D-";
        }
        if (GradIt.getSelectedIndex()==12) {
            grd="E";
        }
        
    }
    
    private void SenrAd(){
        if (FrmSenrAdd.getSelectedIndex()==0) {
            snmcls="Form3";
        }
        if (FrmSenrAdd.getSelectedIndex()==1) {
            snmcls="Form4";
        }
        
        /*if (StrmSenrAdd.getSelectedIndex()==0) {
            snmstr="North";
        }
        if (StrmSenrAdd.getSelectedIndex()==1) {
            snmstr="South";
        }
        if (StrmSenrAdd.getSelectedIndex()==2) {
            snmstr="East";
        }
        if (StrmSenrAdd.getSelectedIndex()==3) {
            snmstr="West";
        }*/
        
        if (SbjSenrChus.getSelectedIndex()==1) {
            snmsbj="Mathematics";
        }
        if (SbjSenrChus.getSelectedIndex()==2) {
            snmsbj="English";
        }
        if (SbjSenrChus.getSelectedIndex()==3) {
            snmsbj="Kiswahili";
        }
        if (SbjSenrChus.getSelectedIndex()==4) {
            snmsbj="Chemistry";
        }
        if (SbjSenrChus.getSelectedIndex()==5) {
            snmsbj="Biology";
        }
        if (SbjSenrChus.getSelectedIndex()==6) {
            snmsbj="Physics";
        }
        if (SbjSenrChus.getSelectedIndex()==7) {
            snmsbj="Geography";
        }
        if (SbjSenrChus.getSelectedIndex()==8) {
            snmsbj="CRE";
        }
        if (SbjSenrChus.getSelectedIndex()==9) {
            snmsbj="History";
        }
        if (SbjSenrChus.getSelectedIndex()==10) {
            snmsbj="Agriculture";
        }
        if (SbjSenrChus.getSelectedIndex()==11) {
            snmsbj="Business";
        }
        if (SbjSenrChus.getSelectedIndex()==0) {
            snmsbj="Null";
        }
    }
    
    private void Str(){
        int Nr,St,Ws,Es;
        try {
                String sql="SELECT * FROM `tbl_ClassList` WHERE `Class`='"+ClStr+"' ";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                while (rs.next()) {
                    Nr=rs.getInt("North");
                    St=rs.getInt("South");
                    Ws=rs.getInt("West");
                    Es=rs.getInt("East");
                    if(Nr ==1){
                        NwStdFrmSrm.addItem("North");
                    }
                    if(St ==1){
                        NwStdFrmSrm.addItem("South");
                    }
                    if(Ws ==1){
                        NwStdFrmSrm.addItem("West");
                    }
                    if(Es ==1){
                        NwStdFrmSrm.addItem("East");
                    }   
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nStr Error");
            }
    }
    
    private void StrNx(){
        int Nr,St,Ws,Es;
        try {
                String sql="SELECT * FROM `tbl_ClassList` WHERE `Class`='"+ClStr+"' ";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                while (rs.next()) {
                    Nr=rs.getInt("North");
                    St=rs.getInt("South");
                    Ws=rs.getInt("West");
                    Es=rs.getInt("East");
                    StrNxt.addItem("All");
                    if(Nr ==1){
                        StrNxt.addItem("North");
                    }
                    if(St ==1){
                        StrNxt.addItem("South");
                    }
                    if(Ws ==1){
                        StrNxt.addItem("West");
                    }
                    if(Es ==1){
                        StrNxt.addItem("East");
                    }   
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nStr Error 22");
            }
    }
    
    private void StrPerf(){
        int Nr,St,Ws,Es;
        try {
                String sql="SELECT * FROM `tbl_ClassList` WHERE `Class`='"+ClStr+"' ";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                while (rs.next()) {
                    Nr=rs.getInt("North");
                    St=rs.getInt("South");
                    Ws=rs.getInt("West");
                    Es=rs.getInt("East");
                    if(Nr ==1){
                        StrPerf.addItem("North");
                    }
                    if(St ==1){
                        StrPerf.addItem("South");
                    }
                    if(Ws ==1){
                        StrPerf.addItem("West");
                    }
                    if(Es ==1){
                        StrPerf.addItem("East");
                    }   
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nStr Error 3");
            }
    }
    
    private void Chus(){
        int Nr,St,Ws,Es;
            try {
                String sql="SELECT * FROM `tbl_ClassList` WHERE `Class`='"+ClStr+"' ";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                while (rs.next()) {
                    Nr=rs.getInt("North");
                    St=rs.getInt("South");
                    Ws=rs.getInt("West");
                    Es=rs.getInt("East");
                    StrmSenrAdd.addItem("-All-");
                    if(Nr ==1){
                        StrmSenrAdd.addItem("North");
                    }
                    if(St ==1){
                        StrmSenrAdd.addItem("South");
                    }
                    if(Ws ==1){
                        StrmSenrAdd.addItem("West");
                    }
                    if(Es ==1){
                        StrmSenrAdd.addItem("East");
                    }   
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nChus");
            }
    }
    
    private void Makeit(){
        String fdsa=null;
        if (RepoClas.getSelectedIndex()==2) {
            fdsa="Form3";
        }
        if (RepoClas.getSelectedIndex()==3) {
            fdsa="Form4";
        }
        try {
                String cops="SELECT Chemistry,Biology,Physics,Geography,CRE,Business,Agriculture FROM `tbl_Placer` WHERE `Class`='"+fdsa+"' ";
                pst=(PreparedStatement) Conn.prepareStatement(cops);
                rs=pst.executeQuery();
                if (rs.next()) {
                    int c1,b2,p3,g4,cr5,b6,a7;
                    c1=rs.getInt("Chemistry");
                    b2=rs.getInt("Biology");
                    p3=rs.getInt("Physics");
                    g4=rs.getInt("Geography");
                    cr5=rs.getInt("CRE");
                    JOptionPane.showMessageDialog(null, "Chemistry"+c1+"\nBiology"+b2+"\nPhysics"+p3+"\nGeography"+g4+"\nCRE"+cr5);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nMade Error");
            }
    }
    
    private void Summ(int stdjmpreg, int stdjmpcls){
        while (rootPaneCheckingEnabled) {            
            
        }
        if (Classe.getSelectedIndex()==0 || Classe.getSelectedIndex()==1) {
            try {
                String cops="SELECT `Mathematics`, `English`, `Kiswahili`, `Chemistry`, `Biology`, `Physics`, `Geography`, `History`, `CRE`, `Business`, `Agriculture` FROM `"+lst+"` WHERE `Reg_No`='"+stdjmpreg+"' ";
                pst=(PreparedStatement) Conn.prepareStatement(cops);
                rs=pst.executeQuery();
                if (rs.next()) {
                    jmpmath=rs.getInt("Mathematics");
                    jmpeng=rs.getInt("English");
                    jmpkiswa=rs.getInt("Kiswahili");
                    jmpchem=rs.getInt("Chemistry");
                    jmpbio=rs.getInt("Biology");
                    jmpphy=rs.getInt("Physics");
                    jmpgeo=rs.getInt("Geography");
                    jmpcre=rs.getInt("CRE");
                    jmphist=rs.getInt("History");
                    jmpbus=rs.getInt("Business");
                    jmpagr=rs.getInt("Agriculture");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nSUmm 1.2 ERROR");
            }
            
            try {
                String cops="SELECT `Mathematics`, `English`, `Kiswahili`, `Chemistry`, `Biology`, `Physics`, `Geography`, `History`, `CRE`, `Business`, `Agriculture` FROM `tbl_MarkP` WHERE `Reg_No`='"+stdjmpcls+"' ";
                pst=(PreparedStatement) Conn.prepareStatement(cops);
                rs=pst.executeQuery();
                if (rs.next()) {
                    jmpmathc=rs.getInt("Mathematics");
                    jmpengc=rs.getInt("English");
                    jmpkiswac=rs.getInt("Kiswahili");
                    jmpchemc=rs.getInt("Chemistry");
                    jmpbioc=rs.getInt("Biology");
                    jmpphyc=rs.getInt("Physics");
                    jmpgeoc=rs.getInt("Geography");
                    jmpcrec=rs.getInt("CRE");
                    jmphistc=rs.getInt("History");
                    jmpbusc=rs.getInt("Business");
                    jmpagrc=rs.getInt("Agriculture");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nSUmm 1.2 Compare");
            }
            int stdpass=1;
            if (jmpmath > jmpagrc || jmpmath == jmpagrc ) {
                stdpass=2;
            }
            else if (jmpeng > jmpengc || jmpengc == jmpengc ) {
                stdpass=2;
            }
            else if (jmpkiswa > jmpkiswac || jmpkiswa == jmpkiswac ) {
                stdpass=2;
            }
            else if (jmpchem > jmpchemc || jmpchem == jmpchemc ) {
                stdpass=2;
            }
            else if (jmpbio > jmpbioc || jmpbio == jmpbioc ) {
                stdpass=2;
            }
            else if (jmpphy > jmpphyc || jmpphy == jmpphyc ) {
                stdpass=2;
            }
            else if (jmpgeo > jmpgeoc || jmpgeo == jmpgeoc ) {
                stdpass=2;
            }
            else if (jmpcre > jmpcrec || jmpcre == jmpcrec ) {
                stdpass=2;
            }
            else if (jmphist > jmphistc || jmphist == jmphistc ) {
                stdpass=2;
            }
            else if (jmpagr > jmpagrc || jmpagr == jmpagrc ) {
                stdpass=2;
            }
            else if (jmpbus > jmpbusc || jmpbus == jmpbusc ) {
                stdpass=2;
            }
            else{
                stdpass=3;
            }
            if (stdpass==2) {
                //Exec pass for Student
            }else{
                //Exec Fail for Student
            }
        }else if (Classe.getSelectedIndex()==2) {
            
        }
        
    }
    
    private void Rugia(){
        int froma=Classe.getSelectedIndex();
        if (froma==0) {
            fromas="Form1";
            Summ(froma,45);
        }
        if (froma==1) {
            fromas="Form2";
        }
        if (froma==2) {
            fromas="Form3";
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        Centa = new javax.swing.JPanel();
        SlCont = new javax.swing.JLabel();
        AddMrk = new javax.swing.JPanel();
        Alll = new javax.swing.JPanel();
        Sett = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        Cbf4 = new javax.swing.JCheckBox();
        jLabel30 = new javax.swing.JLabel();
        YBx = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        Cbf2 = new javax.swing.JCheckBox();
        Tr3 = new javax.swing.JRadioButton();
        ExxamTY = new javax.swing.JComboBox<>();
        Tr1 = new javax.swing.JRadioButton();
        Clser = new javax.swing.JComboBox<>();
        Cbf1 = new javax.swing.JCheckBox();
        Cbf3 = new javax.swing.JCheckBox();
        Tr2 = new javax.swing.JRadioButton();
        Nxt = new javax.swing.JButton();
        Mainn = new javax.swing.JPanel();
        Pg0 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Tsta = new javax.swing.JTable();
        Ada = new javax.swing.JButton();
        Rsh = new javax.swing.JButton();
        Bcer = new javax.swing.JButton();
        Graphyy = new javax.swing.JButton();
        Senr = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        FrmSenrAdd = new javax.swing.JComboBox<>();
        StrmSenrAdd = new javax.swing.JComboBox<>();
        jLabel81 = new javax.swing.JLabel();
        SbjSenrChus = new javax.swing.JComboBox<>();
        SncSenr = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        SnrTblAd = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        SenrConfTbl = new javax.swing.JTable();
        InsrtSenr = new javax.swing.JButton();
        BacSett = new javax.swing.JButton();
        jLabel82 = new javax.swing.JLabel();
        ExamBay = new javax.swing.JComboBox<>();
        Hdd = new javax.swing.JPanel();
        Admin = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        SpacAllc = new javax.swing.JInternalFrame();
        jLabel33 = new javax.swing.JLabel();
        YBx1 = new javax.swing.JComboBox<>();
        ExxamTY1 = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        Cbf5 = new javax.swing.JCheckBox();
        Cbf6 = new javax.swing.JCheckBox();
        Cbf7 = new javax.swing.JCheckBox();
        Cbf8 = new javax.swing.JCheckBox();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        RstCont = new javax.swing.JButton();
        SetCont = new javax.swing.JButton();
        F1Log = new javax.swing.JLabel();
        F2Log = new javax.swing.JLabel();
        F3Log = new javax.swing.JLabel();
        F4Log = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        Tr4 = new javax.swing.JRadioButton();
        Tr5 = new javax.swing.JRadioButton();
        Tr6 = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        Classe = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        ComBin = new javax.swing.JComboBox<>();
        TrnCls = new javax.swing.JButton();
        eXA = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        StrNxt = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        Leva = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        ClassMidPM1 = new javax.swing.JComboBox<>();
        ClassLvMid1 = new javax.swing.JComboBox<>();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        ClassLvMidSbj1 = new javax.swing.JComboBox<>();
        jLabel59 = new javax.swing.JLabel();
        ClassMidFM1 = new javax.swing.JComboBox<>();
        PP1m = new javax.swing.JCheckBox();
        PP2m = new javax.swing.JCheckBox();
        PP3m = new javax.swing.JCheckBox();
        FFMid = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        ClassEndPM1 = new javax.swing.JComboBox<>();
        ClassLvEnd1 = new javax.swing.JComboBox<>();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        ClassLvEndSbj1 = new javax.swing.JComboBox<>();
        jLabel63 = new javax.swing.JLabel();
        ClassEndFM1 = new javax.swing.JComboBox<>();
        PP1e = new javax.swing.JCheckBox();
        PP2e = new javax.swing.JCheckBox();
        PP3e = new javax.swing.JCheckBox();
        FFEnd = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        ClassCatPm1 = new javax.swing.JComboBox<>();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        ClassLvCatSbj1 = new javax.swing.JComboBox<>();
        jLabel66 = new javax.swing.JLabel();
        ClassLvCat1 = new javax.swing.JComboBox<>();
        jLabel67 = new javax.swing.JLabel();
        ClassCatFM1 = new javax.swing.JComboBox<>();
        FFCATS = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        FrmVw = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ClVwTY = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        ClassVw = new javax.swing.JComboBox<>();
        jLabel55 = new javax.swing.JLabel();
        SrchConst = new javax.swing.JComboBox<>();
        ConsBox = new javax.swing.JTextField();
        PrVwStd = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel21 = new javax.swing.JPanel();
        nott = new javax.swing.JLabel();
        OtCom = new javax.swing.JLabel();
        TvwRad = new javax.swing.JRadioButton();
        SvwRad = new javax.swing.JRadioButton();
        Svw = new javax.swing.JPanel();
        Classe1 = new javax.swing.JComboBox<>();
        Trm3 = new javax.swing.JRadioButton();
        Trm2 = new javax.swing.JRadioButton();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        Trm1 = new javax.swing.JRadioButton();
        jLabel48 = new javax.swing.JLabel();
        Cts = new javax.swing.JRadioButton();
        Mts = new javax.swing.JRadioButton();
        Ets = new javax.swing.JRadioButton();
        GenSvw = new javax.swing.JButton();
        Tvw = new javax.swing.JPanel();
        TvwLst = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        GenTvw = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        ConnecView = new javax.swing.JComboBox<>();
        Wrt = new javax.swing.JButton();
        uPtBL = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        CsvGt = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel33 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        AddF1 = new javax.swing.JCheckBox();
        AddF2 = new javax.swing.JCheckBox();
        AddF3 = new javax.swing.JCheckBox();
        AddF4 = new javax.swing.JCheckBox();
        jPanel29 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        AddF1N = new javax.swing.JCheckBox();
        AddF1S = new javax.swing.JCheckBox();
        AddF1E = new javax.swing.JCheckBox();
        AddF1W = new javax.swing.JCheckBox();
        jPanel30 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        AddF2N = new javax.swing.JCheckBox();
        AddF2S = new javax.swing.JCheckBox();
        AddF2E = new javax.swing.JCheckBox();
        AddF2W = new javax.swing.JCheckBox();
        jPanel31 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        AddF3N = new javax.swing.JCheckBox();
        AddF3S = new javax.swing.JCheckBox();
        AddF3E = new javax.swing.JCheckBox();
        AddF3W = new javax.swing.JCheckBox();
        jPanel32 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        AddF4N = new javax.swing.JCheckBox();
        AddF4S = new javax.swing.JCheckBox();
        AddF4E = new javax.swing.JCheckBox();
        AddF4W = new javax.swing.JCheckBox();
        SCls = new javax.swing.JButton();
        jPanel34 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        FormGrad = new javax.swing.JComboBox<>();
        jLabel74 = new javax.swing.JLabel();
        SubGrad = new javax.swing.JComboBox<>();
        jLabel75 = new javax.swing.JLabel();
        GradIt = new javax.swing.JComboBox<>();
        jPanel35 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        Hrange = new javax.swing.JComboBox<>();
        jLabel77 = new javax.swing.JLabel();
        Lrange = new javax.swing.JComboBox<>();
        jPanel36 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        CommBox = new javax.swing.JTextArea();
        jPanel37 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        GraBox = new javax.swing.JTextArea();
        GrdSett = new javax.swing.JButton();
        NwStd = new javax.swing.JPanel();
        Mann = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        FmSch2 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        KcMrk2 = new javax.swing.JTextField();
        Fnm2 = new javax.swing.JTextField();
        Snm2 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        KcGrad2 = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        Canos2 = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        RgNo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        RegAsBtn = new javax.swing.JButton();
        NwStdFrmSrm = new javax.swing.JComboBox<>();
        NwStdDrm = new javax.swing.JComboBox<>();
        NwStdDrmCbl = new javax.swing.JComboBox<>();
        DpImgS = new javax.swing.JDesktopPane();
        DpImg = new javax.swing.JLabel();
        NwStdImg = new javax.swing.JButton();
        ImgP = new javax.swing.JTextField();
        NwStdFrm = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        GCont = new javax.swing.JTextField();
        Gnm = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Gres = new javax.swing.JComboBox<>();
        NwStdReg = new javax.swing.JButton();
        NwStdUpd = new javax.swing.JButton();
        Ext = new javax.swing.JButton();
        Conff = new javax.swing.JPanel();
        NwStdSbj = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        NWstdStNm = new javax.swing.JTextField();
        NWstdStRg = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        NWstdStChm = new javax.swing.JRadioButton();
        NWstdStBio = new javax.swing.JRadioButton();
        NWstdStPhy = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        NWstdStAgr = new javax.swing.JRadioButton();
        NWstdStBus = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        NWstdStGeo = new javax.swing.JRadioButton();
        NWstdStCRE = new javax.swing.JRadioButton();
        NWstdStHist = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        NWstdStFm = new javax.swing.JTextField();
        Repo = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        ExamType = new javax.swing.JComboBox<>();
        PasFail = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        SrtRes = new javax.swing.JTable();
        ClassLv = new javax.swing.JComboBox<>();
        PFSorta = new javax.swing.JButton();
        FltBy = new javax.swing.JComboBox<>();
        PrntRepo = new javax.swing.JButton();
        SbjBox = new javax.swing.JComboBox<>();
        Terma = new javax.swing.JComboBox<>();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Niggatbl = new javax.swing.JTable();
        jPanel39 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        FltPrf = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        Ex2Perf = new javax.swing.JComboBox<>();
        Clss = new javax.swing.JComboBox<>();
        SOmo = new javax.swing.JComboBox<>();
        jLabel84 = new javax.swing.JLabel();
        Ex1Perf = new javax.swing.JComboBox<>();
        jLabel88 = new javax.swing.JLabel();
        StrPerf = new javax.swing.JComboBox<>();
        jPanel23 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel24 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        JrXmGen = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        RepoClas = new javax.swing.JComboBox<>();
        RepoEX = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        RepoTbl = new javax.swing.JTable();
        VwCred = new javax.swing.JButton();
        jLabel68 = new javax.swing.JLabel();
        RepoTrm1 = new javax.swing.JRadioButton();
        RepoTrm2 = new javax.swing.JRadioButton();
        RepoTrm3 = new javax.swing.JRadioButton();
        SyncRepo = new javax.swing.JButton();
        Mprnt = new javax.swing.JButton();
        WannaBe = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        GenTbl = new javax.swing.JComboBox<>();
        GenRepo = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        JrXmGen1 = new javax.swing.JButton();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        RepoClas1 = new javax.swing.JComboBox<>();
        RepoEX1 = new javax.swing.JComboBox<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        RepoTbl1 = new javax.swing.JTable();
        VwCred1 = new javax.swing.JButton();
        jLabel91 = new javax.swing.JLabel();
        RepoTrm4 = new javax.swing.JRadioButton();
        RepoTrm5 = new javax.swing.JRadioButton();
        RepoTrm6 = new javax.swing.JRadioButton();
        SyncRepo1 = new javax.swing.JButton();
        Mprnt1 = new javax.swing.JButton();
        SblistBox = new javax.swing.JComboBox<>();
        jPanel38 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        Heda = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Cpan = new javax.swing.JPanel();
        MnStdeExams = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        MnStdAdd = new javax.swing.JButton();
        MnStdAdminy = new javax.swing.JButton();
        MnStdRepo = new javax.swing.JButton();
        Futa = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Centa.setBackground(new java.awt.Color(204, 204, 255));
        Centa.setMaximumSize(null);
        Centa.setMinimumSize(new java.awt.Dimension(923, 500));
        Centa.setName(""); // NOI18N

        AddMrk.setBackground(new java.awt.Color(255, 250, 255));
        AddMrk.setMinimumSize(new java.awt.Dimension(923, 500));
        AddMrk.setName(""); // NOI18N
        AddMrk.setLayout(new java.awt.BorderLayout());

        Alll.setBackground(new java.awt.Color(204, 204, 255));
        Alll.setMinimumSize(new java.awt.Dimension(923, 420));

        Sett.setBackground(new java.awt.Color(204, 204, 255));
        Sett.setMinimumSize(new java.awt.Dimension(923, 420));
        Sett.setPreferredSize(new java.awt.Dimension(923, 420));

        jLabel24.setText("Term");

        buttonGroup7.add(Cbf4);
        Cbf4.setText("Form 4");

        jLabel30.setText("Exam Type");

        jLabel31.setText("Year");

        jLabel32.setText("Classes");

        buttonGroup7.add(Cbf2);
        Cbf2.setText("Form 2");

        buttonGroup8.add(Tr3);
        Tr3.setText("Term 3");

        ExxamTY.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CATS", "Mid_Term", "End_Term", "-Null-" }));

        buttonGroup8.add(Tr1);
        Tr1.setText("Term 1");

        Clser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Class", "Juniors", "Seniors" }));
        Clser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClserActionPerformed(evt);
            }
        });

        buttonGroup7.add(Cbf1);
        Cbf1.setText("Form 1");

        buttonGroup7.add(Cbf3);
        Cbf3.setText("Form 3");

        buttonGroup8.add(Tr2);
        Tr2.setText("Term 2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ExxamTY, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YBx, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Tr1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(Tr2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Tr3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Clser, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Cbf1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Cbf2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Cbf3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Cbf4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(YBx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExxamTY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(Tr1)
                    .addComponent(Tr2)
                    .addComponent(Tr3))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Clser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cbf1)
                    .addComponent(Cbf2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cbf3)
                    .addComponent(Cbf4))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        Nxt.setText("Next ->");
        Nxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SettLayout = new javax.swing.GroupLayout(Sett);
        Sett.setLayout(SettLayout);
        SettLayout.setHorizontalGroup(
            SettLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                .addComponent(Nxt, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        SettLayout.setVerticalGroup(
            SettLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SettLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Nxt)
                .addGap(68, 68, 68))
        );

        Mainn.setMinimumSize(new java.awt.Dimension(923, 420));
        Mainn.setName(""); // NOI18N
        Mainn.setPreferredSize(new java.awt.Dimension(923, 420));

        Pg0.setBackground(new java.awt.Color(204, 204, 255));
        Pg0.setMinimumSize(new java.awt.Dimension(1000, 392));

        jScrollPane9.setPreferredSize(new java.awt.Dimension(1238, 468));

        Tsta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(Tsta);

        Ada.setText("Commit Changes");
        Ada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdaActionPerformed(evt);
            }
        });

        Rsh.setText("Refresh");
        Rsh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RshActionPerformed(evt);
            }
        });

        Bcer.setText("Back");
        Bcer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcerActionPerformed(evt);
            }
        });

        Graphyy.setText("View Graphs");
        Graphyy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphyyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Pg0Layout = new javax.swing.GroupLayout(Pg0);
        Pg0.setLayout(Pg0Layout);
        Pg0Layout.setHorizontalGroup(
            Pg0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(Pg0Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(Ada)
                .addGap(27, 27, 27)
                .addComponent(Rsh)
                .addGap(18, 18, 18)
                .addComponent(Bcer)
                .addGap(18, 18, 18)
                .addComponent(Graphyy)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Pg0Layout.setVerticalGroup(
            Pg0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pg0Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pg0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ada)
                    .addComponent(Rsh)
                    .addComponent(Bcer)
                    .addComponent(Graphyy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MainnLayout = new javax.swing.GroupLayout(Mainn);
        Mainn.setLayout(MainnLayout);
        MainnLayout.setHorizontalGroup(
            MainnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pg0, javax.swing.GroupLayout.PREFERRED_SIZE, 967, Short.MAX_VALUE)
        );
        MainnLayout.setVerticalGroup(
            MainnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pg0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Senr.setBackground(new java.awt.Color(204, 204, 255));
        Senr.setMinimumSize(new java.awt.Dimension(923, 420));
        Senr.setName(""); // NOI18N
        Senr.setPreferredSize(new java.awt.Dimension(923, 420));

        jLabel79.setText("Form");

        jLabel80.setText("Stream");

        FrmSenrAdd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 3", "Form 4" }));
        FrmSenrAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FrmSenrAddActionPerformed(evt);
            }
        });

        jLabel81.setText("Subject");

        SbjSenrChus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Null--", "Mathematics", "English", "Kiswahili", "Chemistry", "Biology", "Physics", "Geography", "CRE", "History", "Agriculture", "Business" }));
        SbjSenrChus.setName(""); // NOI18N

        SncSenr.setText("Sync");
        SncSenr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SncSenrActionPerformed(evt);
            }
        });

        SnrTblAd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(SnrTblAd);

        SenrConfTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(SenrConfTbl);

        InsrtSenr.setText("Add");
        InsrtSenr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsrtSenrActionPerformed(evt);
            }
        });

        BacSett.setText("Back");
        BacSett.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BacSettActionPerformed(evt);
            }
        });

        jLabel82.setText("Exam");

        ExamBay.setName(""); // NOI18N

        javax.swing.GroupLayout SenrLayout = new javax.swing.GroupLayout(Senr);
        Senr.setLayout(SenrLayout);
        SenrLayout.setHorizontalGroup(
            SenrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SenrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SenrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SenrLayout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SenrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BacSett)
                            .addComponent(InsrtSenr))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SenrLayout.createSequentialGroup()
                        .addGroup(SenrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(SenrLayout.createSequentialGroup()
                                .addComponent(jLabel79)
                                .addGap(29, 29, 29)
                                .addComponent(FrmSenrAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel80))
                            .addGroup(SenrLayout.createSequentialGroup()
                                .addComponent(jLabel81)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SbjSenrChus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8)))
                        .addGroup(SenrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SncSenr)
                            .addGroup(SenrLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(StrmSenrAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel82)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ExamBay, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        SenrLayout.setVerticalGroup(
            SenrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SenrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SenrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SenrLayout.createSequentialGroup()
                        .addGap(0, 97, Short.MAX_VALUE)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SenrLayout.createSequentialGroup()
                        .addGroup(SenrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel79)
                            .addComponent(FrmSenrAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel80)
                            .addComponent(StrmSenrAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel82)
                            .addComponent(ExamBay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(SenrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel81)
                            .addComponent(SbjSenrChus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SncSenr))
                        .addGroup(SenrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SenrLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SenrLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(InsrtSenr)
                                .addGap(39, 39, 39)
                                .addComponent(BacSett)
                                .addGap(23, 23, 23)))))
                .addContainerGap())
        );

        javax.swing.GroupLayout AlllLayout = new javax.swing.GroupLayout(Alll);
        Alll.setLayout(AlllLayout);
        AlllLayout.setHorizontalGroup(
            AlllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 967, Short.MAX_VALUE)
            .addGroup(AlllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AlllLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Sett, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(AlllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AlllLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(Mainn, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
            .addGroup(AlllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AlllLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(Senr, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        AlllLayout.setVerticalGroup(
            AlllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
            .addGroup(AlllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AlllLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Sett, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(AlllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AlllLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(Mainn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(21, 21, 21)))
            .addGroup(AlllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AlllLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(Senr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(21, 21, 21)))
        );

        AddMrk.add(Alll, java.awt.BorderLayout.CENTER);

        Hdd.setMinimumSize(new java.awt.Dimension(923, 80));
        Hdd.setPreferredSize(new java.awt.Dimension(923, 80));

        javax.swing.GroupLayout HddLayout = new javax.swing.GroupLayout(Hdd);
        Hdd.setLayout(HddLayout);
        HddLayout.setHorizontalGroup(
            HddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 967, Short.MAX_VALUE)
        );
        HddLayout.setVerticalGroup(
            HddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        AddMrk.add(Hdd, java.awt.BorderLayout.PAGE_START);

        Admin.setMinimumSize(new java.awt.Dimension(923, 500));
        Admin.setName(""); // NOI18N

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        SpacAllc.setBackground(new java.awt.Color(204, 204, 204));
        SpacAllc.setVisible(true);

        jLabel33.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("AnyTitle Here");
        jLabel33.setToolTipText("");

        ExxamTY1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CATS", "Mid_Term", "End_Term" }));

        jLabel34.setText("Classes");

        Cbf5.setText("Form 1");

        Cbf6.setText("Form 2");

        Cbf7.setText("Form 3");

        Cbf8.setText("Form 4");

        jLabel35.setText("Exam Type");

        jLabel36.setText("Year");

        jLabel37.setFont(new java.awt.Font("LM Sans 10", 1, 14)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Exams and Tests Allocation Section");

        RstCont.setText("Reset");
        RstCont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RstContActionPerformed(evt);
            }
        });

        SetCont.setText("Set");
        SetCont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetContActionPerformed(evt);
            }
        });

        F1Log.setText("jLabel6");

        F2Log.setText("jLabel7");

        F3Log.setText("jLabel8");

        F4Log.setText("jLabel9");

        jLabel38.setText("Term");

        buttonGroup4.add(Tr4);
        Tr4.setText("Term 1");

        buttonGroup4.add(Tr5);
        Tr5.setText("Term 2");

        buttonGroup4.add(Tr6);
        Tr6.setText("Term 3");

        javax.swing.GroupLayout SpacAllcLayout = new javax.swing.GroupLayout(SpacAllc.getContentPane());
        SpacAllc.getContentPane().setLayout(SpacAllcLayout);
        SpacAllcLayout.setHorizontalGroup(
            SpacAllcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SpacAllcLayout.createSequentialGroup()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 344, Short.MAX_VALUE))
            .addGroup(SpacAllcLayout.createSequentialGroup()
                .addGroup(SpacAllcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SpacAllcLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(SpacAllcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(SpacAllcLayout.createSequentialGroup()
                                .addGroup(SpacAllcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(SpacAllcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ExxamTY1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(YBx1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(SpacAllcLayout.createSequentialGroup()
                                        .addGroup(SpacAllcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Cbf5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(F1Log, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(SpacAllcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Cbf6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(F2Log, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(SpacAllcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Cbf7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(F3Log, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(SpacAllcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Cbf8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(F4Log, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(SpacAllcLayout.createSequentialGroup()
                                        .addComponent(Tr4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(Tr5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(Tr6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(SpacAllcLayout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(RstCont)
                        .addGap(88, 88, 88)
                        .addComponent(SetCont))
                    .addGroup(SpacAllcLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel38)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SpacAllcLayout.setVerticalGroup(
            SpacAllcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SpacAllcLayout.createSequentialGroup()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(SpacAllcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(YBx1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addGroup(SpacAllcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExxamTY1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addGap(18, 18, 18)
                .addGroup(SpacAllcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(Tr4)
                    .addComponent(Tr5)
                    .addComponent(Tr6))
                .addGap(23, 23, 23)
                .addGroup(SpacAllcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbf5)
                    .addComponent(Cbf6)
                    .addComponent(Cbf7)
                    .addComponent(Cbf8))
                .addGap(18, 18, 18)
                .addGroup(SpacAllcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(F1Log)
                    .addComponent(F2Log)
                    .addComponent(F3Log)
                    .addComponent(F4Log))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(SpacAllcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RstCont)
                    .addComponent(SetCont))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SpacAllc)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SpacAllc)
        );

        jTabbedPane1.addTab("Add Tables", jPanel2);

        Classe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1", "Form 2", "Form 3" }));
        Classe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClasseActionPerformed(evt);
            }
        });

        jLabel39.setText("Form");

        jLabel40.setText("Action");

        jLabel41.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Select Student To Transfer To Next Class");
        jLabel41.setToolTipText("All Student Carried to Next are Above Passmark");

        ComBin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proceed", "Repeat", "Default" }));
        ComBin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComBinActionPerformed(evt);
            }
        });

        TrnCls.setText("Affirm");
        TrnCls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrnClsActionPerformed(evt);
            }
        });

        eXA.setEditable(false);

        jLabel86.setText("Stream");

        StrNxt.setName(""); // NOI18N
        StrNxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StrNxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Classe, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel86)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(StrNxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComBin, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(eXA, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TrnCls)
                .addContainerGap())
            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Classe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(ComBin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eXA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TrnCls)
                    .addComponent(jLabel86)
                    .addComponent(StrNxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Leva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(Leva);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Transfers", jPanel9);

        jPanel10.setDoubleBuffered(false);
        jPanel10.setFocusable(false);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Mid-Term Results"));

        ClassLvMid1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1", "Form 2", "Form 3", "Form 4" }));

        jLabel56.setText("Form");

        jLabel57.setText("Subject");

        jLabel58.setText("Pass Marks");

        ClassLvMidSbj1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Subjects", "Mathematics", "English", "Kiswahili", "Chemistry", "Biology", "Physics", "Geography", "CRE", "History", "Agriculture", "Business" }));
        ClassLvMidSbj1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassLvMidSbj1ActionPerformed(evt);
            }
        });

        jLabel59.setText("Fail Mark");

        PP1m.setText("Paper One");

        PP2m.setText("Paper Two");

        PP3m.setText("Paper Three");

        FFMid.setText("Set");
        FFMid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FFMidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ClassLvMid1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel57)
                .addGap(32, 32, 32)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(PP1m)
                        .addGap(18, 18, 18)
                        .addComponent(PP2m)
                        .addGap(18, 18, 18)
                        .addComponent(PP3m)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(FFMid))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(ClassLvMidSbj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ClassMidPM1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ClassMidFM1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClassMidPM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58)
                    .addComponent(ClassLvMidSbj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57)
                    .addComponent(ClassLvMid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56)
                    .addComponent(jLabel59)
                    .addComponent(ClassMidFM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PP1m)
                    .addComponent(PP3m)
                    .addComponent(PP2m)
                    .addComponent(FFMid))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("End-Term Results"));

        ClassLvEnd1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1", "Form 2", "Form 3", "Form 4" }));

        jLabel60.setText("Form");

        jLabel61.setText("Subject");

        jLabel62.setText("Pass Marks");

        ClassLvEndSbj1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Subjects", "Mathematics", "English", "Kiswahili", "Chemistry", "Biology", "Physics", "Geography", "CRE", "History", "Agriculture", "Business" }));
        ClassLvEndSbj1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassLvEndSbj1ActionPerformed(evt);
            }
        });

        jLabel63.setText("Fail Mark");

        PP1e.setText("Paper One");

        PP2e.setText("Paper Two");

        PP3e.setText("Paper Three");

        FFEnd.setText("Set");
        FFEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FFEndActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ClassLvEnd1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel61)
                .addGap(37, 37, 37)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(PP1e)
                        .addGap(18, 18, 18)
                        .addComponent(PP2e)
                        .addGap(18, 18, 18)
                        .addComponent(PP3e)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(FFEnd))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(ClassLvEndSbj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ClassEndPM1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ClassEndFM1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClassEndPM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(ClassLvEndSbj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61)
                    .addComponent(ClassLvEnd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60)
                    .addComponent(jLabel63)
                    .addComponent(ClassEndFM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PP2e)
                    .addComponent(PP3e)
                    .addComponent(PP1e)
                    .addComponent(FFEnd)))
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder("CAT Results"));

        jLabel64.setText("Pass Marks");

        jLabel65.setText("Subject");

        ClassLvCatSbj1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Subjects", "Mathematics", "English", "Kiswahili", "Chemistry", "Biology", "Physics", "Geography", "CRE", "History", "Agriculture", "Business" }));

        jLabel66.setText("Form");

        ClassLvCat1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form1", "Form2", "Form3", "Form4" }));

        jLabel67.setText("Fail Mark");

        FFCATS.setText("Set");
        FFCATS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FFCATSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ClassLvCat1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel65)
                .addGap(36, 36, 36)
                .addComponent(ClassLvCatSbj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel64)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ClassCatPm1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ClassCatFM1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FFCATS)
                .addGap(203, 203, 203))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClassCatPm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64)
                    .addComponent(ClassLvCatSbj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65)
                    .addComponent(ClassLvCat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66)
                    .addComponent(jLabel67)
                    .addComponent(ClassCatFM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(FFCATS))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jTabbedPane1.addTab("Setting Marks", null, jPanel10, "");

        javax.swing.GroupLayout FrmVwLayout = new javax.swing.GroupLayout(FrmVw);
        FrmVw.setLayout(FrmVwLayout);
        FrmVwLayout.setHorizontalGroup(
            FrmVwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );
        FrmVwLayout.setVerticalGroup(
            FrmVwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        ClVwTY.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(ClVwTY);

        jLabel54.setText("Filter");

        ClassVw.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form1", "Form2", "Form3", "Form4" }));
        ClassVw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassVwActionPerformed(evt);
            }
        });

        jLabel55.setText("Search");

        SrchConst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reg No", "Name", "Class" }));

        ConsBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsBoxActionPerformed(evt);
            }
        });
        ConsBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ConsBoxKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ConsBoxKeyReleased(evt);
            }
        });

        PrVwStd.setText("Print View");
        PrVwStd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrVwStdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54)
                    .addComponent(jLabel55))
                .addGap(76, 76, 76)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ClassVw, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SrchConst, 0, 99, Short.MAX_VALUE))
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(ConsBox, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PrVwStd)
                        .addGap(53, 53, 53))))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(ClassVw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(SrchConst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(PrVwStd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FrmVw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addGap(30, 30, 30))
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FrmVw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Student List", jPanel18);

        nott.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        nott.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nott.setText("*Generates Current Exam Table From The Local Database For Uploading To Remote Database");
        nott.setEnabled(false);

        OtCom.setText("jLabel4");

        buttonGroup5.add(TvwRad);
        TvwRad.setText("Tabular View");
        TvwRad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TvwRadActionPerformed(evt);
            }
        });

        buttonGroup5.add(SvwRad);
        SvwRad.setText("Selective View");
        SvwRad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SvwRadActionPerformed(evt);
            }
        });

        Classe1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1", "Form 2", "Form 3", "Form 4" }));

        buttonGroup2.add(Trm3);
        Trm3.setText("Term 3");

        buttonGroup2.add(Trm2);
        Trm2.setText("Term 2");

        jLabel46.setText("Class");

        jLabel47.setText("Term");

        buttonGroup2.add(Trm1);
        Trm1.setText("Term 1");

        jLabel48.setText("Exam");

        buttonGroup3.add(Cts);
        Cts.setText("CATS");

        buttonGroup3.add(Mts);
        Mts.setText("Mid-Term");

        buttonGroup3.add(Ets);
        Ets.setText("End-Term");

        GenSvw.setText("Generate");
        GenSvw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenSvwActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SvwLayout = new javax.swing.GroupLayout(Svw);
        Svw.setLayout(SvwLayout);
        SvwLayout.setHorizontalGroup(
            SvwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SvwLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SvwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SvwLayout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(28, 28, 28)
                        .addComponent(Classe1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SvwLayout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addGap(27, 27, 27)
                        .addComponent(Trm1)
                        .addGap(38, 38, 38)
                        .addComponent(Trm2)
                        .addGap(18, 18, 18)
                        .addComponent(Trm3))
                    .addGroup(SvwLayout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addGap(27, 27, 27)
                        .addComponent(Cts)
                        .addGap(38, 38, 38)
                        .addComponent(Mts)
                        .addGap(18, 18, 18)
                        .addComponent(Ets)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SvwLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(GenSvw)
                .addGap(28, 28, 28))
        );
        SvwLayout.setVerticalGroup(
            SvwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SvwLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SvwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Classe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addGap(18, 18, 18)
                .addGroup(SvwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(Trm1)
                    .addComponent(Trm2)
                    .addComponent(Trm3))
                .addGap(18, 18, 18)
                .addGroup(SvwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(Cts)
                    .addComponent(Mts)
                    .addComponent(Ets))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(GenSvw)
                .addContainerGap())
        );

        jLabel49.setText("Table");

        GenTvw.setText("Generate");
        GenTvw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenTvwActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TvwLayout = new javax.swing.GroupLayout(Tvw);
        Tvw.setLayout(TvwLayout);
        TvwLayout.setHorizontalGroup(
            TvwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TvwLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TvwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TvwLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(GenTvw))
                    .addGroup(TvwLayout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(TvwLst, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        TvwLayout.setVerticalGroup(
            TvwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TvwLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TvwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TvwLst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(GenTvw)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nott, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TvwRad)
                            .addComponent(Tvw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SvwRad)
                            .addComponent(Svw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 127, Short.MAX_VALUE))
                    .addComponent(OtCom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TvwRad)
                    .addComponent(SvwRad))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Svw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tvw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addComponent(OtCom)
                .addGap(18, 18, 18)
                .addComponent(nott)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Generate", jPanel21);

        jLabel50.setText("Internet Connection");

        ConnecView.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Connected", "Connection Error" }));

        Wrt.setText("Write");
        Wrt.setEnabled(false);
        Wrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WrtActionPerformed(evt);
            }
        });

        uPtBL.setName(""); // NOI18N

        jLabel51.setText("Table Of Interest");

        jLabel87.setText("File (.csv)");

        CsvGt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CsvGtMouseClicked(evt);
            }
        });
        CsvGt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CsvGtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(381, 381, 381)
                        .addComponent(Wrt))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ConnecView, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uPtBL, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CsvGt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(506, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConnecView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50))
                .addGap(55, 55, 55)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uPtBL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51))
                .addGap(50, 50, 50)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(CsvGt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(Wrt)
                .addGap(77, 77, 77))
        );

        jTabbedPane3.addTab("Upload", jPanel22);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jTabbedPane3)
                .addGap(0, 0, 0))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jTabbedPane3)
                .addGap(32, 32, 32))
        );

        jTabbedPane1.addTab("Upload Results", jPanel17);

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder("Forms"));

        jLabel45.setText("Add Classes To Interact With");

        AddF1.setText("Form 1");
        AddF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddF1ActionPerformed(evt);
            }
        });

        AddF2.setText("Form 2");
        AddF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddF2ActionPerformed(evt);
            }
        });

        AddF3.setText("Form 3");
        AddF3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddF3ActionPerformed(evt);
            }
        });

        AddF4.setText("Form 4");
        AddF4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddF4ActionPerformed(evt);
            }
        });

        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("Stream In Form 1");

        AddF1N.setText("North");

        AddF1S.setText("South");

        AddF1E.setText("East");

        AddF1W.setText("West");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddF1N)
                    .addComponent(AddF1S)
                    .addComponent(AddF1E)
                    .addComponent(AddF1W))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(jLabel69)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddF1N)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddF1S)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddF1E)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddF1W)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("Stream In Form 2");

        AddF2N.setText("North");

        AddF2S.setText("South");

        AddF2E.setText("East");

        AddF2W.setText("West");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddF2N)
                    .addComponent(AddF2S)
                    .addComponent(AddF2E)
                    .addComponent(AddF2W))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(jLabel70)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddF2N)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddF2S)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddF2E)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddF2W)
                .addGap(0, 47, Short.MAX_VALUE))
        );

        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("Stream In Form 3");

        AddF3N.setText("North");

        AddF3S.setText("South");

        AddF3E.setText("East");

        AddF3W.setText("West");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddF3N)
                    .addComponent(AddF3S)
                    .addComponent(AddF3E)
                    .addComponent(AddF3W))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jLabel71)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddF3N)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddF3S)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddF3E)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddF3W)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("Stream In Form 4");

        AddF4N.setText("North");

        AddF4S.setText("South");

        AddF4E.setText("East");

        AddF4W.setText("West");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddF4N)
                    .addComponent(AddF4S)
                    .addComponent(AddF4E)
                    .addComponent(AddF4W))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddF4N)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddF4S)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddF4E)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddF4W)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        SCls.setText("Set Classes");
        SCls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SClsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AddF3)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addGap(18, 18, 18)
                                .addComponent(AddF1)))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddF2)
                            .addComponent(AddF4)))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SCls, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(AddF1)
                    .addComponent(AddF2))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddF3)
                    .addComponent(AddF4))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addComponent(SCls)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );

        jTabbedPane5.addTab("Streams", jPanel33);

        jLabel73.setText("Form");

        FormGrad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1", "Form 2", "Form 3", "Form 4" }));

        jLabel74.setText("SubJect");

        SubGrad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Subjects", "Mathematics", "English", "Kiswahili", "Chemistry", "Biology", "Physics", "Geography", "CRE", "History", "Agriculture", "Business" }));
        SubGrad.setEnabled(false);

        jLabel75.setText("Grade");

        GradIt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Null", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "E" }));

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder("Grade Range"));

        jLabel76.setText("Highest Range");

        jLabel77.setText("Lowest Amount");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel76)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Hrange, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(Lrange, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(jLabel77)
                    .addComponent(Hrange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lrange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder("Grade Comment"));

        jLabel78.setText("Comment");

        CommBox.setColumns(20);
        CommBox.setRows(5);
        jScrollPane6.setViewportView(CommBox);

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel78))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder("Grading Report"));

        GraBox.setColumns(20);
        GraBox.setRows(5);
        GraBox.setEnabled(false);
        jScrollPane11.setViewportView(GraBox);

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
        );

        GrdSett.setText("Submit");
        GrdSett.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrdSettActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addGap(26, 26, 26)
                        .addComponent(FormGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel74)
                        .addGap(31, 31, 31)
                        .addComponent(SubGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                        .addComponent(GrdSett)
                        .addGap(88, 88, 88)))
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GradIt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(FormGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74)
                    .addComponent(SubGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75)
                    .addComponent(GradIt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(GrdSett))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Grading", jPanel34);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(jTabbedPane5)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Variables", jPanel27);

        javax.swing.GroupLayout AdminLayout = new javax.swing.GroupLayout(Admin);
        Admin.setLayout(AdminLayout);
        AdminLayout.setHorizontalGroup(
            AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 967, Short.MAX_VALUE)
        );
        AdminLayout.setVerticalGroup(
            AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
        );

        NwStd.setMaximumSize(null);
        NwStd.setMinimumSize(new java.awt.Dimension(923, 500));
        NwStd.setName(""); // NOI18N

        Mann.setBackground(new java.awt.Color(204, 204, 204));
        Mann.setMinimumSize(new java.awt.Dimension(858, 490));
        Mann.setName(""); // NOI18N

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Student Details"));

        jLabel22.setText("Full Name");

        jLabel23.setText("Surname");

        jLabel25.setText("Former Sch.");

        jLabel26.setText("KCPE Marks");

        KcMrk2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                KcMrk2KeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                KcMrk2KeyReleased(evt);
            }
        });

        jLabel27.setText("KCPE Grade");

        KcGrad2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "-Null-" }));

        jLabel28.setText("Birth");

        Canos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Canos2ActionPerformed(evt);
            }
        });

        jLabel29.setText("Special Care");

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("Present");

        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setText("Null");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FmSch2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(22, 22, 22)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Snm2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(KcMrk2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(KcGrad2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Canos2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jRadioButton5)
                                    .addGap(18, 18, 18)
                                    .addComponent(jRadioButton6))))
                        .addComponent(Fnm2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(Fnm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(Snm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(FmSch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(KcMrk2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(KcGrad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(Canos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Assign Details"));

        jLabel10.setText("Assign Reg No");

        RgNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RgNoKeyTyped(evt);
            }
        });

        jLabel11.setText("Assign Form");

        jLabel12.setText("Assign Dorm");

        RegAsBtn.setText("Re-Assign");
        RegAsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegAsBtnActionPerformed(evt);
            }
        });

        NwStdFrmSrm.setName(""); // NOI18N

        NwStdDrm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dorm 1", "Dorm 2", "Dorm 3", "Dorm 4", "Dorm 5" }));

        NwStdDrmCbl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        DpImgS.setLayer(DpImg, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DpImgSLayout = new javax.swing.GroupLayout(DpImgS);
        DpImgS.setLayout(DpImgSLayout);
        DpImgSLayout.setHorizontalGroup(
            DpImgSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DpImgSLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DpImg, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addContainerGap())
        );
        DpImgSLayout.setVerticalGroup(
            DpImgSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DpImgSLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DpImg, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );

        NwStdImg.setText("...");
        NwStdImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NwStdImgActionPerformed(evt);
            }
        });

        NwStdFrm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form1", "Form2", "Form3", "Form4" }));
        NwStdFrm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NwStdFrmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(RgNo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(RegAsBtn))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NwStdDrm, 0, 100, Short.MAX_VALUE)
                                    .addComponent(NwStdFrm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(73, 73, 73)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(NwStdFrmSrm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NwStdDrmCbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(ImgP, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(NwStdImg, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(DpImgS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(RgNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegAsBtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(NwStdFrmSrm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NwStdFrm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(NwStdDrm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NwStdDrmCbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(DpImgS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImgP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NwStdImg)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Guardian Details"));

        GCont.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                GContKeyTyped(evt);
            }
        });

        jLabel13.setText("Contacts");

        jLabel14.setText("Guardian");

        jLabel15.setText("Residence");

        Gres.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kiambu", "Murang'a", "Nairoboi", "Nyeri", "Nyandarua", "Nakuru", "Laikipia" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(22, 22, 22)
                            .addComponent(GCont, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(Gnm, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(Gres, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(Gnm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(GCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(Gres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        NwStdReg.setText("Add Student");
        NwStdReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NwStdRegActionPerformed(evt);
            }
        });

        NwStdUpd.setText("Update");
        NwStdUpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NwStdUpdActionPerformed(evt);
            }
        });

        Ext.setText("Exit");
        Ext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MannLayout = new javax.swing.GroupLayout(Mann);
        Mann.setLayout(MannLayout);
        MannLayout.setHorizontalGroup(
            MannLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MannLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MannLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(MannLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MannLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(MannLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(NwStdReg)
                        .addGap(27, 27, 27)
                        .addComponent(NwStdUpd)
                        .addGap(37, 37, 37)
                        .addComponent(Ext)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        MannLayout.setVerticalGroup(
            MannLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MannLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MannLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MannLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MannLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MannLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NwStdReg)
                            .addComponent(NwStdUpd)
                            .addComponent(Ext))))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        Conff.setBackground(new java.awt.Color(204, 204, 255));
        Conff.setMinimumSize(new java.awt.Dimension(923, 500));
        Conff.setName(""); // NOI18N

        NwStdSbj.setText("Set");
        NwStdSbj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NwStdSbjActionPerformed(evt);
            }
        });

        jLabel16.setText("Name");

        jLabel17.setText("Reg No");

        NWstdStChm.setText("Chemistry");

        NWstdStBio.setText("Biology");

        NWstdStPhy.setText("Physics");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NWstdStPhy)
                    .addComponent(NWstdStBio)
                    .addComponent(NWstdStChm))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(NWstdStChm)
                .addGap(18, 18, 18)
                .addComponent(NWstdStBio)
                .addGap(26, 26, 26)
                .addComponent(NWstdStPhy)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel18.setText("Sciences");

        NWstdStAgr.setText("Agriculture");

        NWstdStBus.setText("Business Studies");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NWstdStBus)
                    .addComponent(NWstdStAgr))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(NWstdStAgr)
                .addGap(18, 18, 18)
                .addComponent(NWstdStBus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        NWstdStGeo.setText("Geography");

        NWstdStCRE.setText("C.R.E");

        NWstdStHist.setText("History");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NWstdStHist)
                    .addComponent(NWstdStCRE)
                    .addComponent(NWstdStGeo))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(NWstdStGeo)
                .addGap(18, 18, 18)
                .addComponent(NWstdStCRE)
                .addGap(26, 26, 26)
                .addComponent(NWstdStHist)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel19.setText("Humanities");

        jLabel20.setText("Technicals");

        jLabel21.setText("Form");

        javax.swing.GroupLayout ConffLayout = new javax.swing.GroupLayout(Conff);
        Conff.setLayout(ConffLayout);
        ConffLayout.setHorizontalGroup(
            ConffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConffLayout.createSequentialGroup()
                .addGroup(ConffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConffLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(ConffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ConffLayout.createSequentialGroup()
                                .addGroup(ConffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel21))
                                .addGap(50, 50, 50)
                                .addGroup(ConffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NWstdStFm, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ConffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(NWstdStNm)
                                        .addComponent(NWstdStRg, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(ConffLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19)))
                        .addGap(146, 146, 146)
                        .addComponent(jLabel20))
                    .addGroup(ConffLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(211, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConffLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(NwStdSbj)
                .addGap(99, 99, 99))
        );
        ConffLayout.setVerticalGroup(
            ConffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConffLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(NWstdStNm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ConffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(NWstdStRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ConffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(NWstdStFm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(ConffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel18))
                .addGap(6, 6, 6)
                .addGroup(ConffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(NwStdSbj)
                .addGap(67, 67, 67))
        );

        javax.swing.GroupLayout NwStdLayout = new javax.swing.GroupLayout(NwStd);
        NwStd.setLayout(NwStdLayout);
        NwStdLayout.setHorizontalGroup(
            NwStdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Mann, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(NwStdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(NwStdLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(Conff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        NwStdLayout.setVerticalGroup(
            NwStdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NwStdLayout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(Mann, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(NwStdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(NwStdLayout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(Conff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        Repo.setMinimumSize(new java.awt.Dimension(923, 500));
        Repo.setName(""); // NOI18N

        ExamType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CATS", "Mid-Term", "End-Term" }));

        PasFail.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pass", "Fail", "Try" }));

        SrtRes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(SrtRes);

        ClassLv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1", "Form 2", "Form 3", "Form 4" }));

        PFSorta.setText("Sort");
        PFSorta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PFSortaActionPerformed(evt);
            }
        });

        FltBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Descending", "Ascending" }));

        PrntRepo.setText("Print");
        PrntRepo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrntRepoActionPerformed(evt);
            }
        });

        SbjBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Subjects", "Mathematics", "English", "Kiswahili", "Chemistry", "Biology", "Physics", "Geography", "CRE", "History", "Agriculture", "B/S" }));
        SbjBox.setName(""); // NOI18N

        Terma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Term 1", "Term 2", "Term 3" }));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ClassLv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ExamType, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Terma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SbjBox, 0, 1, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(PasFail, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(FltBy, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PFSorta)
                .addGap(73, 73, 73)
                .addComponent(PrntRepo)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExamType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasFail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClassLv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PFSorta)
                    .addComponent(FltBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrntRepo)
                    .addComponent(SbjBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Terma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("View", jPanel15);

        Niggatbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Niggatbl);

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder("Set Constraints"));

        jLabel83.setText("Exam 1");

        jLabel44.setText("Filter");

        FltPrf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Compare", "Highest", "Lowest" }));
        FltPrf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FltPrfActionPerformed(evt);
            }
        });

        jLabel43.setText("Subject");

        jLabel42.setText("Class");

        Ex2Perf.setName(""); // NOI18N

        Clss.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1", "Form 2", "Form 3", "Form 4" }));
        Clss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClssActionPerformed(evt);
            }
        });

        SOmo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mathematics", "English", "Kiswahili", "Chemistry", "Biology", "Physics", "Geography", "History", "CRE", "Agriculture", "Business" }));

        jLabel84.setText("Exam 2");

        Ex1Perf.setName(""); // NOI18N

        jLabel88.setText("Stream");

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Clss, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SOmo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel88)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StrPerf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel83)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Ex1Perf, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel84)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Ex2Perf, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FltPrf, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(Clss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel88))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ex1Perf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel83)
                            .addComponent(StrPerf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(SOmo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FltPrf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44)))
                    .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Ex2Perf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel84)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Performance", jPanel16);

        JrXmGen.setText("Generate");
        JrXmGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JrXmGenActionPerformed(evt);
            }
        });

        jLabel52.setText("Exam Of Interest");

        jLabel53.setText("Class");

        RepoClas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1", "Form 2", "Form 3", "Form 4", "--Null--" }));

        RepoEX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CATS", "Mid-Term", "End-Term", "--Null--" }));

        RepoTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(RepoTbl);

        VwCred.setText("View");
        VwCred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VwCredActionPerformed(evt);
            }
        });

        jLabel68.setText("Exam Type");

        RepoTrm1.setText("Term 1");

        RepoTrm2.setText("Term 2");

        RepoTrm3.setText("Term 3");

        SyncRepo.setText("Sync");
        SyncRepo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SyncRepoActionPerformed(evt);
            }
        });

        Mprnt.setText("Many Print");
        Mprnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MprntActionPerformed(evt);
            }
        });

        WannaBe.setText("Result Sheet");
        WannaBe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WannaBeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jScrollPane5)
                        .addContainerGap())
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RepoEX, 0, 110, Short.MAX_VALUE)
                            .addComponent(RepoClas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(RepoTrm1)
                                .addGap(18, 18, 18)
                                .addComponent(RepoTrm2)
                                .addGap(18, 18, 18)
                                .addComponent(RepoTrm3)
                                .addGap(38, 38, 38)
                                .addComponent(WannaBe))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(SyncRepo)
                                .addGap(126, 126, 126)
                                .addComponent(Mprnt)
                                .addGap(33, 33, 33)
                                .addComponent(JrXmGen, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(VwCred)))
                        .addGap(51, 51, 51))))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(RepoClas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68)
                    .addComponent(RepoTrm1)
                    .addComponent(RepoTrm2)
                    .addComponent(RepoTrm3)
                    .addComponent(WannaBe))
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52)
                            .addComponent(RepoEX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SyncRepo)))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JrXmGen)
                            .addComponent(VwCred)
                            .addComponent(Mprnt))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Single", jPanel24);

        GenRepo.setText("Generate");
        GenRepo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenRepoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(GenRepo))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(GenTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(GenTbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(GenRepo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("tab2", jPanel25);

        JrXmGen1.setText("Generate");
        JrXmGen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JrXmGen1ActionPerformed(evt);
            }
        });

        jLabel89.setText("Exam Of Interest");

        jLabel90.setText("Class");

        RepoClas1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 3", "Form 4", "--Null--" }));

        RepoEX1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CATS", "Mid-Term", "End-Term", "--Null--" }));

        RepoTbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(RepoTbl1);

        VwCred1.setText("View");
        VwCred1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VwCred1ActionPerformed(evt);
            }
        });

        jLabel91.setText("Exam Type");

        RepoTrm4.setText("Term 1");

        RepoTrm5.setText("Term 2");

        RepoTrm6.setText("Term 3");

        SyncRepo1.setText("Sync");
        SyncRepo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SyncRepo1ActionPerformed(evt);
            }
        });

        Mprnt1.setText("Many Print");
        Mprnt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mprnt1ActionPerformed(evt);
            }
        });

        SblistBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Subject", "Chemistry", "Biology", "Physics", "Geography", "History", "CRE", "Agriculture", "Business" }));

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jScrollPane7)
                        .addContainerGap())
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel89)
                            .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RepoEX1, 0, 110, Short.MAX_VALUE)
                            .addComponent(RepoClas1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel41Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(RepoTrm4)
                                .addGap(18, 18, 18)
                                .addComponent(RepoTrm5)
                                .addGap(18, 18, 18)
                                .addComponent(RepoTrm6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel41Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(SblistBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(SyncRepo1)
                                .addGap(18, 18, 18)
                                .addComponent(Mprnt1)
                                .addGap(33, 33, 33)
                                .addComponent(JrXmGen1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(VwCred1)
                                .addGap(51, 51, 51))))))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90)
                    .addComponent(RepoClas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel91)
                    .addComponent(RepoTrm4)
                    .addComponent(RepoTrm5)
                    .addComponent(RepoTrm6))
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel89)
                            .addComponent(RepoEX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SyncRepo1)
                            .addComponent(SblistBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JrXmGen1)
                            .addComponent(VwCred1)
                            .addComponent(Mprnt1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Double", jPanel40);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Reports", jPanel23);

        jLabel85.setText("Form");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel85)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(797, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(437, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Analysis", jPanel38);

        javax.swing.GroupLayout RepoLayout = new javax.swing.GroupLayout(Repo);
        Repo.setLayout(RepoLayout);
        RepoLayout.setHorizontalGroup(
            RepoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        RepoLayout.setVerticalGroup(
            RepoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        javax.swing.GroupLayout CentaLayout = new javax.swing.GroupLayout(Centa);
        Centa.setLayout(CentaLayout);
        CentaLayout.setHorizontalGroup(
            CentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SlCont, javax.swing.GroupLayout.DEFAULT_SIZE, 967, Short.MAX_VALUE)
            .addGroup(CentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(AddMrk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(CentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Admin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(CentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CentaLayout.createSequentialGroup()
                    .addComponent(NwStd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
            .addGroup(CentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Repo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CentaLayout.setVerticalGroup(
            CentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SlCont, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
            .addGroup(CentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(AddMrk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(CentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CentaLayout.createSequentialGroup()
                    .addComponent(Admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(29, 29, 29)))
            .addGroup(CentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CentaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(NwStd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(CentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CentaLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(Repo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(21, 21, 21)))
        );

        getContentPane().add(Centa, java.awt.BorderLayout.CENTER);

        Heda.setBackground(new java.awt.Color(204, 204, 204));
        Heda.setPreferredSize(new java.awt.Dimension(1045, 80));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Testing v3.0");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Testing v3.0 mini");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout HedaLayout = new javax.swing.GroupLayout(Heda);
        Heda.setLayout(HedaLayout);
        HedaLayout.setHorizontalGroup(
            HedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
        );
        HedaLayout.setVerticalGroup(
            HedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HedaLayout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
        );

        jLabel8.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(Heda, java.awt.BorderLayout.PAGE_START);

        Cpan.setBackground(new java.awt.Color(204, 153, 255));

        MnStdeExams.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgy/view-pim-tasks.png"))); // NOI18N
        MnStdeExams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnStdeExamsActionPerformed(evt);
            }
        });

        jLabel1.setText("Registrations");

        jLabel2.setText("Exams");

        jLabel3.setText("Reports");

        jLabel4.setText("Miscellaneous");

        MnStdAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgy/add_user.png"))); // NOI18N
        MnStdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnStdAddActionPerformed(evt);
            }
        });

        MnStdAdminy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgy/view-process-own.png"))); // NOI18N
        MnStdAdminy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnStdAdminyActionPerformed(evt);
            }
        });

        MnStdRepo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgy/office-chart-pie.png"))); // NOI18N
        MnStdRepo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnStdRepoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CpanLayout = new javax.swing.GroupLayout(Cpan);
        Cpan.setLayout(CpanLayout);
        CpanLayout.setHorizontalGroup(
            CpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CpanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MnStdRepo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CpanLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(CpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MnStdeExams, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MnStdAdd, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(CpanLayout.createSequentialGroup()
                        .addComponent(MnStdAdminy)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        CpanLayout.setVerticalGroup(
            CpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CpanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MnStdAdd)
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(MnStdeExams)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(MnStdRepo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(MnStdAdminy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        getContentPane().add(Cpan, java.awt.BorderLayout.LINE_START);

        Futa.setPreferredSize(new java.awt.Dimension(1045, 60));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Contact Me At");
        jLabel5.setEnabled(false);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("My address Is Here");
        jLabel6.setEnabled(false);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ChegeCache.site88.net");
        jLabel7.setEnabled(false);

        javax.swing.GroupLayout FutaLayout = new javax.swing.GroupLayout(Futa);
        Futa.setLayout(FutaLayout);
        FutaLayout.setHorizontalGroup(
            FutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        FutaLayout.setVerticalGroup(
            FutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FutaLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel7))
        );

        getContentPane().add(Futa, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MnStdeExamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnStdeExamsActionPerformed
        // TODO add your handling code here:
        Admin.setVisible(Boolean.FALSE);
        AddMrk.setVisible(Boolean.TRUE);
        NwStd.setVisible(Boolean.FALSE);
        Repo.setVisible(Boolean.FALSE);
        Putta();
        Star();
    }//GEN-LAST:event_MnStdeExamsActionPerformed

    private void MnStdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnStdAddActionPerformed
        // TODO add your handling code here:
        Admin.setVisible(Boolean.FALSE);
        AddMrk.setVisible(Boolean.FALSE);
        Repo.setVisible(Boolean.FALSE);
        NwStd.setVisible(Boolean.TRUE);
        Hoppa();
        
    }//GEN-LAST:event_MnStdAddActionPerformed

    private void MnStdAdminyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnStdAdminyActionPerformed
        // TODO add your handling code here:
        Str();
        Wrt.setEnabled(Boolean.FALSE);
        Admin.setVisible(Boolean.TRUE);
        Repo.setVisible(Boolean.FALSE);
        AddMrk.setVisible(Boolean.FALSE);
        NwStd.setVisible(Boolean.FALSE);
    }//GEN-LAST:event_MnStdAdminyActionPerformed

    private void MnStdRepoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnStdRepoActionPerformed
        // TODO add your handling code here:
        Admin.setVisible(Boolean.FALSE);
        Repo.setVisible(Boolean.TRUE);
        AddMrk.setVisible(Boolean.FALSE);
        NwStd.setVisible(Boolean.FALSE);
    }//GEN-LAST:event_MnStdRepoActionPerformed

    private void KcMrk2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KcMrk2KeyReleased
        // TODO add your handling code here:
        Uppa();
    }//GEN-LAST:event_KcMrk2KeyReleased

    private void Canos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Canos2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Canos2ActionPerformed

    private void RegAsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegAsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegAsBtnActionPerformed

    private void NwStdImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NwStdImgActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser prip=new JFileChooser();
            FileFilter flft=new FileNameExtensionFilter("Images Only", new String []{"jpg","png","jpeg"});

            prip.setFileFilter(flft);
            prip.addChoosableFileFilter(flft);
            int rtn=prip.showOpenDialog(null);
            
            if (rtn==JFileChooser.APPROVE_OPTION) {
                File f= new File(prip.getSelectedFile().getAbsolutePath());//prip.getSelectedFile();
                Patt=f.getAbsolutePath();
                ImgP.setText(Patt);

                ImageIcon stV=new ImageIcon(Patt);
                Image Sd=stV.getImage().getScaledInstance(DpImg.getWidth(),DpImg.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon im=new ImageIcon(Sd);
                DpImg.setIcon(im);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Null or Invalid 'Image' File");
        }
        /*try {
            JFileChooser prip=new JFileChooser();
            prip.showOpenDialog(null);
            File f=prip.getSelectedFile();
            Patt=f.getAbsolutePath();
            ImgP.setText(Patt);

            ImageIcon stV=new ImageIcon(Patt);
            Image Sd=stV.getImage().getScaledInstance(DpImg.getWidth(),DpImg.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon im=new ImageIcon(Sd);
            DpImg.setIcon(im);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Null or Invalid 'Image' File");
        }*/
    }//GEN-LAST:event_NwStdImgActionPerformed

    private void NwStdFrmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NwStdFrmActionPerformed
        // TODO add your handling code here:
        if (NwStdFrm.getSelectedIndex()==0) {
            ClStr="Form1";
            NwStdFrmSrm.removeAllItems();
            Str();
        }
        if (NwStdFrm.getSelectedIndex()==1) {
            ClStr="Form2";
            NwStdFrmSrm.removeAllItems();
            Str();
        }
        if (NwStdFrm.getSelectedIndex()==2) {
            ClStr="Form3";
            NwStdFrmSrm.removeAllItems();
            Str();
        }
        if (NwStdFrm.getSelectedIndex()==3) {
            ClStr="Form4";
            NwStdFrmSrm.removeAllItems();
            Str();
        }
        
        
        if (NwStdFrm.getSelectedIndex()>1) {
            Mann.setVisible(Boolean.FALSE);
            Conff.setVisible(Boolean.TRUE);
        }

        NWstdStNm.setText(Fnm2.getText().toString());
        NWstdStRg.setText(RgNo.getText().toString());
        NWstdStFm.setText(NwStdFrm.getSelectedItem().toString());

    }//GEN-LAST:event_NwStdFrmActionPerformed

    private void NwStdRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NwStdRegActionPerformed
        // TODO add your handling code here:
        try {
            String Kret="INSERT INTO `tbl_Students` (`Count`,`Name` ,`Surname` ,`Reg_No` ,`KCPE` ,`Birth` ,`Class` ,`Stream` ,`Dorm` ,`Parent` ,`Residence` ,`Contact`,`Avatar` ) VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?)";
            File img=new File(Patt);
            FileInputStream fis=new FileInputStream(img);
            int len=(int)img.length();
            pst= (PreparedStatement) Conn.prepareStatement(Kret);

            pst.setString(1, Fnm2.getText().toString());
            pst.setString(2, Snm2.getText().toString());
            pst.setInt(3, Integer.parseInt(RgNo.getText()));
            pst.setInt(4, Integer.parseInt(KcMrk2.getText()));
            pst.setInt(5, Integer.parseInt(Canos2.getSelectedItem().toString()));
            pst.setString(6, NwStdFrm.getSelectedItem().toString());
            pst.setString(7, NwStdFrmSrm.getSelectedItem().toString());
            pst.setString(8, NwStdDrm.getSelectedItem().toString());
            pst.setString(9, Gnm.getText().toString());
            pst.setString(10, Gres.getSelectedItem().toString());
            pst.setInt(11, Integer.parseInt(GCont.getText()));
            pst.setBinaryStream(12,fis, len);

            pst.executeUpdate();

            try {
                if (NwStdFrm.getSelectedItem().toString()=="Form4" ||NwStdFrm.getSelectedItem().toString()=="Form3" ) {
                    lv="INSERT INTO `tbl_Placer` (`Count` ,`Reg_No`,`Class`,`Stream` ) VALUES (NULL,?,?,?)";
                    pst=(PreparedStatement) Conn.prepareStatement(lv);
                    pst.setInt(1, Integer.parseInt(RgNo.getText()));
                    pst.setString(2, NwStdFrm.getSelectedItem().toString());
                    pst.setString(3, NwStdFrmSrm.getSelectedItem().toString());
                    pst.executeUpdate();
                    
                    Cutta();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nPlacement Error");
                Toolkit.getDefaultToolkit().beep();
            }

            try {
                String sql="SELECT `Test` FROM `tbl_Tests` ORDER BY `Count` DESC LIMIT 1";
                pst= (PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if (rs.next()) {
                    String lst=rs.getString("Test");
                    lv="INSERT INTO `"+lst+"` (`Count`,`Name`,`Class`,`Reg_No`,Stream ) VALUES (NULL,?,?,?,?)";
                    pst=(PreparedStatement) Conn.prepareStatement(lv);
                    pst.setInt(3, Integer.parseInt(RgNo.getText()));
                    pst.setString(2, NwStdFrm.getSelectedItem().toString());
                    pst.setString(4, NwStdFrmSrm.getSelectedItem().toString());
                    pst.setString(1, Fnm2.getText().toString());
                    pst.executeUpdate();
                    //JOptionPane.showMessageDialog(null, lst);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nCurrent Exam Table Error");
                Toolkit.getDefaultToolkit().beep();
            }

            JOptionPane.showMessageDialog(null, "New Student "+Fnm2.getText().toString()+" Succesfully Inserted");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex+"\nThink Big");
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_NwStdRegActionPerformed

    private void NwStdUpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NwStdUpdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NwStdUpdActionPerformed

    private void ExtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExtActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_ExtActionPerformed

    private void NwStdSbjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NwStdSbjActionPerformed
        // TODO add your handling code here:
        //Cutta();
        Conff.setVisible(Boolean.FALSE);
        Mann.setVisible(Boolean.TRUE);
    }//GEN-LAST:event_NwStdSbjActionPerformed

    private void ClserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClserActionPerformed
        // TODO add your handling code here:
        String gt=Clser.getSelectedItem().toString();
        if (gt=="Juniors") {
            Cbf1.setEnabled(true);
            Cbf2.setEnabled(true);
            Cbf3.setEnabled(false);
            Cbf4.setEnabled(false);
        }else if (gt=="Seniors") {
            Cbf1.setEnabled(false);
            Cbf2.setEnabled(false);
            Cbf3.setEnabled(true);
            Cbf4.setEnabled(true);
        }
    }//GEN-LAST:event_ClserActionPerformed

    private void AdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tts=(DefaultTableModel) Tsta.getModel();
        try {
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("Mathematics");
                Double kk=Double.valueOf(Tsta.getValueAt(i, 3).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("English");
                Double kk=Double.valueOf(Tsta.getValueAt(i, 4).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("Kiswahili");
                Double kk=Double.valueOf(Tsta.getValueAt(i, 5).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("Chemistry");
                Double kk=Double.valueOf(Tsta.getValueAt(i, 6).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("Biology");
                Double kk=Double.valueOf(Tsta.getValueAt(i, 7).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("Physics");
                Double kk=Double.valueOf(Tsta.getValueAt(i, 8).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("Geography");
                Double kk=Double.valueOf(Tsta.getValueAt(i, 9).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("History");
                //float kk=Integer.parseInt(Tsta.getValueAt(i, 10).toString()) ;
                Double kk=Double.valueOf(Tsta.getValueAt(i, 10).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("CRE");
                Double kk=Double.valueOf(Tsta.getValueAt(i, 11).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("Business");
                Double kk=Double.valueOf(Tsta.getValueAt(i, 12).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("Agriculture");
                Double kk=Double.valueOf(Tsta.getValueAt(i, 13).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            JOptionPane.showMessageDialog(null, "Done");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"Nigga");
        }
    }//GEN-LAST:event_AdaActionPerformed

    private void RshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RshActionPerformed
        // TODO add your handling code here:
        Putta();
    }//GEN-LAST:event_RshActionPerformed

    private void BcerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcerActionPerformed
        // TODO add your handling code here:
        Mainn.setVisible(Boolean.FALSE);
        Sett.setVisible(Boolean.TRUE);
        Senr.setVisible(Boolean.FALSE);
    }//GEN-LAST:event_BcerActionPerformed

    private void GraphyyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphyyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GraphyyActionPerformed

    private void NxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NxtActionPerformed
        // TODO add your handling code here:
        //2017_End_Term_Term2
        Putta();
        ExamBay.addItem(lst);
        ExamBay.setEnabled(Boolean.FALSE);
        if (!(Cbf3.isSelected() || Cbf4.isSelected() || Cbf1.isSelected() || Cbf2.isSelected())) {
            JOptionPane.showMessageDialog(null, "Check A Class To Proceed");
        }
        else if (Cbf3.isSelected() || Cbf4.isSelected()) {
            Sett.setVisible(Boolean.FALSE);
            Senr.setVisible(Boolean.TRUE);
            Mainn.setVisible(Boolean.FALSE);
        }
        else if (Cbf1.isSelected() || Cbf2.isSelected()) {
            Sett.setVisible(Boolean.FALSE);
            Senr.setVisible(Boolean.FALSE);
            Mainn.setVisible(Boolean.TRUE);
        }
    }//GEN-LAST:event_NxtActionPerformed

    private void RstContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RstContActionPerformed
        // TODO add your handling code here:
        //YBx.setSelectedItem(2014);
        /*Cbf5.setSelected(false);
        Cbf6.setSelected(false);
        Cbf7.setSelected(false);
        Cbf8.setSelected(false);*/
        F1Log.setText(null);
        F4Log.setText(null);
        F3Log.setText(null);
        F2Log.setText(null);
        //Conf();
    }//GEN-LAST:event_RstContActionPerformed

    private void SetContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetContActionPerformed
        // TODO add your handling code here:
        int t=Integer.parseInt((String) YBx1.getSelectedItem());
        String tty1=((String) ExxamTY1.getSelectedItem().toString());
        Droop();
        Conf();

        //if (Cbf1.isSelected()) {
            //F1Log.setText("Pending");
            //Mats="Form1";
            //cs=t+"_"+tty1+"_"+Tem+"_"+Mats;
            cs=t+"_"+tty1+"_"+Tem;
            try{
                String Std="CREATE TABLE IF NOT EXISTS `"+cs+"` (`Count` int(3) NOT NULL AUTO_INCREMENT,`Name` varchar(50) NOT NULL,`Class` VARCHAR(5) NOT NULL,"
                + "`Reg_No` int(10) NOT NULL,`Stream` varchar(10) NOT NULL,`Mathematics` float NOT NULL DEFAULT '0',`English` float NOT NULL DEFAULT '0',"
                + "`Kiswahili` float NOT NULL DEFAULT '0',`Chemistry` float NOT NULL DEFAULT '0',`Biology` float NOT NULL DEFAULT '0',"
                + "`Physics` float NOT NULL DEFAULT '0',`Geography` float NOT NULL DEFAULT '0',`History` float NOT NULL DEFAULT '0',"
                + "`CRE` float NOT NULL DEFAULT '0',`Business` float NOT NULL DEFAULT '0',`Agriculture` float NOT NULL DEFAULT '0',"
                + "PRIMARY KEY (Reg_No),UNIQUE (`Count`) )";

                PreparedStatement pst1 = (PreparedStatement) Conn.prepareStatement(Std);
                pst1.execute();

                Filla();

                JOptionPane.showMessageDialog(null,cs+" Table Building Sucesfull");

                //F1Log.setText("Sucess");

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex+"\nForm Table Bulding Segmentation Fault");
                //F1Log.setText("Failed");
            }
            //}

        /*if (Cbf2.isSelected()) {
            F2Log.setText("Pending");
            Mats="Form2";
            //cs=t+"_"+tty1+"_"+Tem+"_"+Mats;
            cs=t+"_"+tty1+"_"+Tem;
            try{
                String Std="CREATE TABLE IF NOT EXISTS `"+cs+"` (`Count` int(3) NOT NULL AUTO_INCREMENT,`Name` varchar(50) NOT NULL,`Class` VARCHAR(5) NOT NULL,"
                + "`Reg_No` int(10) NOT NULL,`Mathematics` float NOT NULL DEFAULT '0',`English` float NOT NULL DEFAULT '0',"
                + "`Kiswahili` float NOT NULL DEFAULT '0',`Chemistry` float NOT NULL DEFAULT '0',`Biology` float NOT NULL DEFAULT '0',"
                + "`Physics` float NOT NULL DEFAULT '0',`Geography` float NOT NULL DEFAULT '0',`History` float NOT NULL DEFAULT '0',"
                + "`CRE` float NOT NULL DEFAULT '0',`Business` float NOT NULL DEFAULT '0',`Agriculture` float NOT NULL DEFAULT '0',"
                + "PRIMARY KEY (Reg_No),UNIQUE (`Count`) )";

                PreparedStatement pst1 = conn.prepareStatement(Std);
                pst1.execute();

                Filla();

                F2Log.setText("Sucess");

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex+"\nForm 2 Segmentation Fault");
                F2Log.setText("Failed");
            }
        }

        if (Cbf3.isSelected()) {
            F3Log.setText("Pending");
            Mats="Form3";
            //cs=t+"_"+tty1+"_"+Tem+"_"+Mats;
            cs=t+"_"+tty1+"_"+Tem;
            try{
                String Std="CREATE TABLE IF NOT EXISTS `"+cs+"` (`Count` int(3) NOT NULL AUTO_INCREMENT,`Name` varchar(50) NOT NULL,`Class` VARCHAR(5) NOT NULL,"
                + "`Reg_No` int(10) NOT NULL,`Mathematics` float NOT NULL DEFAULT '0',`English` float NOT NULL DEFAULT '0',"
                + "`Kiswahili` float NOT NULL DEFAULT '0',`Chemistry` float NOT NULL DEFAULT '0',`Biology` float NOT NULL DEFAULT '0',"
                + "`Physics` float NOT NULL DEFAULT '0',`Geography` float NOT NULL DEFAULT '0',`History` float NOT NULL DEFAULT '0',"
                + "`CRE` float NOT NULL DEFAULT '0',`Business` float NOT NULL DEFAULT '0',`Agriculture` float NOT NULL DEFAULT '0',"
                + "PRIMARY KEY (Reg_No),UNIQUE (`Count`) )";

                PreparedStatement pst1 = conn.prepareStatement(Std);
                pst1.execute();

                Filla();

                F3Log.setText("Sucess");

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex+"\nForm 3 Segmentation Fault");
                F3Log.setText("Failed");
            }
        }

        if (Cbf4.isSelected()) {
            F4Log.setText("Pending");
            Mats="Form4";
            //cs=t+"_"+tty1+"_"+Tem+"_"+Mats;
            cs=t+"_"+tty1+"_"+Tem;
            try{
                String Std="CREATE TABLE IF NOT EXISTS `"+cs+"` (`Count` int(3) NOT NULL AUTO_INCREMENT,`Name` varchar(50) NOT NULL,`Class` VARCHAR(5) NOT NULL,"
                + "`Reg_No` int(10) NOT NULL,`Mathematics` float NOT NULL DEFAULT '0',`English` float NOT NULL DEFAULT '0',"
                + "`Kiswahili` float NOT NULL DEFAULT '0',`Chemistry` float NOT NULL DEFAULT '0',`Biology` float NOT NULL DEFAULT '0',"
                + "`Physics` float NOT NULL DEFAULT '0',`Geography` float NOT NULL DEFAULT '0',`History` float NOT NULL DEFAULT '0',"
                + "`CRE` float NOT NULL DEFAULT '0',`Business` float NOT NULL DEFAULT '0',`Agriculture` float NOT NULL DEFAULT '0',"
                + "PRIMARY KEY (Reg_No),UNIQUE (`Count`) )";

                PreparedStatement pst1 = conn.prepareStatement(Std);
                pst1.execute();

                Filla();

                F4Log.setText("Sucess");

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex+"\nForm 4 Segmentation Fault");
                F4Log.setText("Failed");
            }
        }*/

        try {
            String Puz4="INSERT INTO `tbl_Tests` (`Count`, `Test`) VALUES (NULL, '"+cs+"' )";
            PreparedStatement pstf4 = (PreparedStatement) Conn.prepareStatement(Puz4);
            pstf4.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e+"\nTest Above Already Exists");
        }

    }//GEN-LAST:event_SetContActionPerformed

    private void TrnClsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrnClsActionPerformed
        // TODO add your handling code here:
        int aigana=Leva.getSelectedRowCount(),ndari=0,regpass=0;
        String newcls=null;
        if (Classe.getSelectedIndex()==0){
            newcls="Form2";
        }
        if (Classe.getSelectedIndex()==1){
            newcls="Form3";
        }
        if (Classe.getSelectedIndex()==2){
            newcls="Form4";
        }
        if (Leva.getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(null, "Atleast a Single Selection"+aigana);
        }else{
            int[] ro=Leva.getSelectedRows();
            for (int i =0; i < (aigana+0); i++) {
                String cc0=Leva.getModel().getValueAt(ro[i], 1).toString();
                try {
                    String cc=Leva.getModel().getValueAt(ro[i], 3).toString();
                    String norol="UPDATE `tbl_Students` SET `CLASS`='"+newcls+"' WHERE `Reg_No`=' "+cc+" '";
                    pst=(PreparedStatement) Conn.prepareStatement(norol);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, ro[i]+" Students Succesfully Proceeded to "+newcls);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "\nProgression Error"+ e);
                }
            }
        }
        /*int cl =JOptionPane.showConfirmDialog(this,"Transfer To Next Level","Proceed", JOptionPane.YES_NO_OPTION);
        if (cl==JOptionPane.YES_OPTION) {
            Rugia();
            if (ComBin.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog(null, "Pass to "+fromas);
                //Update stm
            } else if (ComBin.getSelectedIndex()==1){
                JOptionPane.showMessageDialog(null, "Repeated in "+fromas);
            }
        }
        if (cl==JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Failed");
            //remove(cl);
        }*/
    }//GEN-LAST:event_TrnClsActionPerformed

    private void ClassVwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClassVwActionPerformed
        // TODO add your handling code here:
        String Dop=ClassVw.getSelectedItem().toString();
        try {
            String Lv="SELECT  Name,Surname,Reg_No,KCPE,Class,Dorm,Parent,Residence,Contact  FROM `tbl_Students`  WHERE Class= '"+Dop+"' ";
            pst=(PreparedStatement) Conn.prepareStatement(Lv);
            rs=pst.executeQuery();
                ClVwTY.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\n"+Dop);
        }
    }//GEN-LAST:event_ClassVwActionPerformed

    private void ConsBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsBoxActionPerformed
        // TODO add your handling code here:
        Searc();
    }//GEN-LAST:event_ConsBoxActionPerformed

    private void ConsBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ConsBoxKeyTyped
        // TODO add your handling code here:
        Searc();
    }//GEN-LAST:event_ConsBoxKeyTyped

    private void ConsBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ConsBoxKeyReleased
        // TODO add your handling code here:
        Searc();
    }//GEN-LAST:event_ConsBoxKeyReleased

    private void ClassLvMidSbj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClassLvMidSbj1ActionPerformed
        // TODO add your handling code here:
        if (ClassLvMidSbj1.getSelectedIndex()==0 ){
            PP1m.setEnabled(false);
            PP2m.setEnabled(false);
            PP3m.setEnabled(false);
        }else if (ClassLvMidSbj1.getSelectedIndex()>0 ){
            PP1m.setEnabled(true);
            PP2m.setEnabled(true);
            PP3m.setEnabled(true);
        }
    }//GEN-LAST:event_ClassLvMidSbj1ActionPerformed

    private void FFMidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FFMidActionPerformed
        // TODO add your handling code here:
        ths="Mid";
        fcll=ClassLvMid1.getSelectedItem().toString();
        Setta();
        SBJ=ClassLvMidSbj1.getSelectedItem().toString();
        sbjPck=(ClassLvMidSbj1.getSelectedIndex());
        pmp=Integer.parseInt(ClassMidPM1.getSelectedItem().toString());
        pmf=Integer.parseInt(ClassMidFM1.getSelectedItem().toString());
        if (sbjPck==0) {
            try {
                //String UpdF="UPDATE `tbl_MarkF` SET `Form`='"+fcll+"',`Exam`='"+fcll+"',`Term`='"+Trm+"',`Mathematics`=' "+pmf+" ',`English`=' "+pmf+" ',`Kiswahili`=' "+pmf+" ',`Chemistry`=' "+pmf+" ',`Biology`=' "+pmf+" ',`Physics`=' "+pmf+" ',`Geography`=' "+pmf+" ',`History`=' "+pmf+" ',`CRE`=' "+pmf+" ',`Business`=' "+pmf+" ',`Agriculture`=' "+pmf+" ' WHERE `Code`=' "+spa+" ' ";
                String Std="INSERT INTO `tbl_MarkF`(`Count`, `Year`, `Form`, `Exam`, `Term`, `Mathematics`, `English`, `Kiswahili`, `Chemistry`, `Biology`, `Physics`, `Geography`, `History`, `CRE`, `Business`, `Agriculture`) VALUES (NULL,' "+ya+" ','"+fcll+"','"+ths+"','"+Trm+"',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ')";
                PreparedStatement pst1 = (PreparedStatement) Conn.prepareStatement(Std);
                pst1.execute();

                String Std2="INSERT INTO `tbl_MarkP`(`Count`, `Year`, `Form`, `Exam`, `Term`, `Mathematics`, `English`, `Kiswahili`, `Chemistry`, `Biology`, `Physics`, `Geography`, `History`, `CRE`, `Business`, `Agriculture`) VALUES (NULL,' "+ya+" ','"+fcll+"','"+ths+"','"+Trm+"',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ')";
                PreparedStatement pst2 = (PreparedStatement) Conn.prepareStatement(Std2);
                pst2.execute();
                
                JOptionPane.showMessageDialog(null, "\nSucesfully Done\n"+SBJ+" Range Set Is "+pmp+" <-+->"+pmf+"");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nUpdation Of Margins/Range Of All Subject Errored");
            }
        }else if (sbjPck>0) {
            try {
                String UpdF="INSERT INTO `tbl_MarkF` (`Count`, `Year`, `Form`, `Exam`, `Term`, `"+SBJ+"`) VALUES (NULL,' "+ya+" ','"+fcll+"','"+ths+"','"+spa+"',' "+pmf+" ' )";
                PreparedStatement pstf = (PreparedStatement) Conn.prepareStatement(UpdF);
                pstf.executeUpdate();

                String UpdP="INSERT INTO `tbl_MarkP` (`Count`, `Year`, `Form`, `Exam`, `Term`, `"+SBJ+"`) VALUES (NULL,' "+ya+" ','"+fcll+"','"+ths+"','"+spa+"',' "+pmp+" ' )";
                PreparedStatement pstp = (PreparedStatement) Conn.prepareStatement(UpdP);
                pstp.executeUpdate();

                JOptionPane.showMessageDialog(null, "\nSucesfully Done\n"+SBJ+" Range Set Is "+pmp+" <-+->"+pmf+"");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nUpdation Of Margins/Range Of "+SBJ+" Errored");
            }
        }
    }//GEN-LAST:event_FFMidActionPerformed

    private void ClassLvEndSbj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClassLvEndSbj1ActionPerformed
        // TODO add your handling code here:
        if (ClassLvEndSbj1.getSelectedIndex()==0 ){
            PP1e.setEnabled(false);
            PP2e.setEnabled(false);
            PP3e.setEnabled(false);
        }else if (ClassLvEndSbj1.getSelectedIndex()>0 ){
            PP1e.setEnabled(true);
            PP2e.setEnabled(true);
            PP3e.setEnabled(true);
        }
    }//GEN-LAST:event_ClassLvEndSbj1ActionPerformed

    private void FFEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FFEndActionPerformed
        // TODO add your handling code here:
        ths="End";
        Setta();
        fcll=ClassLvEnd1.getSelectedItem().toString();
        SBJ=ClassLvEndSbj1.getSelectedItem().toString();
        sbjPck=(ClassLvEndSbj1.getSelectedIndex());
        pmp=Integer.parseInt(ClassEndPM1.getSelectedItem().toString());
        pmf=Integer.parseInt(ClassEndFM1.getSelectedItem().toString());
        if (sbjPck==0) {
            try {
                //String UpdF="UPDATE `tbl_MarkF` SET `Form`='"+fcll+"',`Exam`='"+fcll+"',`Term`='"+Trm+"',`Mathematics`=' "+pmf+" ',`English`=' "+pmf+" ',`Kiswahili`=' "+pmf+" ',`Chemistry`=' "+pmf+" ',`Biology`=' "+pmf+" ',`Physics`=' "+pmf+" ',`Geography`=' "+pmf+" ',`History`=' "+pmf+" ',`CRE`=' "+pmf+" ',`Business`=' "+pmf+" ',`Agriculture`=' "+pmf+" ' WHERE `Code`=' "+spa+" ' ";
                String Std="INSERT INTO `tbl_MarkF`(`Count`, `Year`, `Form`, `Exam`, `Term`, `Mathematics`, `English`, `Kiswahili`, `Chemistry`, `Biology`, `Physics`, `Geography`, `History`, `CRE`, `Business`, `Agriculture`) VALUES (NULL,' "+ya+" ','"+fcll+"','"+ths+"','"+Trm+"',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ')";
                PreparedStatement pst1 = (PreparedStatement) Conn.prepareStatement(Std);
                pst1.execute();

                String Std2="INSERT INTO `tbl_MarkP`(`Count`, `Year`, `Form`, `Exam`, `Term`, `Mathematics`, `English`, `Kiswahili`, `Chemistry`, `Biology`, `Physics`, `Geography`, `History`, `CRE`, `Business`, `Agriculture`) VALUES (NULL,' "+ya+" ','"+fcll+"','"+ths+"','"+Trm+"',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ')";
                PreparedStatement pst2 = (PreparedStatement) Conn.prepareStatement(Std2);
                pst2.execute();

                JOptionPane.showMessageDialog(null, "\nSucesfully Done\n"+SBJ+" Range Set Is "+pmp+" <-+->"+pmf+"");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nUpdation Of Margins/Range Of All Subjects Errored"+fcll);
            }
        }else if (sbjPck>0) {
            try {
                String UpdF="INSERT INTO `tbl_MarkF` (`Count`, `Year`, `Form`, `Exam`, `Term`, `"+SBJ+"`) VALUES (NULL,' "+ya+" ','"+fcll+"','"+ths+"','"+Trm+"',' "+pmf+" ' )";
                PreparedStatement pstf = (PreparedStatement) Conn.prepareStatement(UpdF);
                pstf.executeUpdate();

                String UpdP="INSERT INTO `tbl_MarkP` (`Count`, `Year`, `Form`, `Exam`,` `Term`, `"+SBJ+"`) VALUES (NULL,' "+ya+" ','"+fcll+"','"+ths+"','"+Trm+"',' "+pmp+" ' )";
                PreparedStatement pstp = (PreparedStatement) Conn.prepareStatement(UpdP);
                pstp.executeUpdate();

                JOptionPane.showMessageDialog(null, "\nSucesfully Done\n"+SBJ+" Range Set Is "+pmp+" <-+->"+pmf+"");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nUpdation Of Margins/Range Of "+SBJ+" Errored");
            }
        }

    }//GEN-LAST:event_FFEndActionPerformed

    private void FFCATSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FFCATSActionPerformed
        // TODO add your handling code here:
        ths="CATS";
        Setta();
        fcll=ClassLvCat1.getSelectedItem().toString();
        pmp=Integer.parseInt(ClassCatPm1.getSelectedItem().toString());
        pmf=Integer.parseInt(ClassCatFM1.getSelectedItem().toString());
        if (sbjPck==0) {
            try {
                //String UpdF="UPDATE `tbl_MarkF` SET `Form`='"+fcll+"',`Exam`='"+fcll+"',`Term`='"+Trm+"',`Mathematics`=' "+pmf+" ',`English`=' "+pmf+" ',`Kiswahili`=' "+pmf+" ',`Chemistry`=' "+pmf+" ',`Biology`=' "+pmf+" ',`Physics`=' "+pmf+" ',`Geography`=' "+pmf+" ',`History`=' "+pmf+" ',`CRE`=' "+pmf+" ',`Business`=' "+pmf+" ',`Agriculture`=' "+pmf+" ' WHERE `Code`=' "+spa+" ' ";
                String Std="INSERT INTO `tbl_MarkF`(`Count`, `Year`, `Form`, `Exam`,`Term`, `Mathematics`, `English`, `Kiswahili`, `Chemistry`, `Biology`, `Physics`, `Geography`, `History`, `CRE`, `Business`, `Agriculture`) VALUES (NULL,' "+ya+" ',' "+fcll+" ','"+ths+"','"+Trm+"',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ')";
                PreparedStatement pst1 = (PreparedStatement) Conn.prepareStatement(Std);
                pst1.execute();

                String Std2="INSERT INTO `tbl_MarkP`(`Count`, `Year`, `Form`, `Exam`, `Term`, `Mathematics`, `English`, `Kiswahili`, `Chemistry`, `Biology`, `Physics`, `Geography`, `History`, `CRE`, `Business`, `Agriculture`) VALUES (NULL,' "+ya+" ',' "+fcll+" ','"+ths+"','"+Trm+"',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ')";
                PreparedStatement pst2 = (PreparedStatement) Conn.prepareStatement(Std2);
                pst2.execute();

                JOptionPane.showMessageDialog(null, "\nSucesfully Done\n"+SBJ+" Range Set Is "+pmp+" <-+->"+pmf+"");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nUpdation Of Margins/Range Of "+SBJ+" Errored");
            }
        }else if (sbjPck>0) {
            try {
                String UpdF="INSERT INTO `tbl_MarkF` (`Count`, `Year`, `Form`, `Exam`, `Term`, `"+SBJ+"`) VALUES (NULL,' "+ya+" ','"+fcll+"','"+ths+"','"+Trm+"',' "+pmf+" ' )";
                PreparedStatement pstf = (PreparedStatement) Conn.prepareStatement(UpdF);
                pstf.executeUpdate();

                String UpdP="INSERT INTO `tbl_MarkP` (`Count`, `Year`, `Form`, `Exam`, `Term`, `"+SBJ+"`) VALUES (NULL,' "+ya+" ','"+fcll+"','"+ths+"','"+Trm+"',' "+pmp+" ' )";
                PreparedStatement pstp = (PreparedStatement) Conn.prepareStatement(UpdP);
                pstp.executeUpdate();

                JOptionPane.showMessageDialog(null, "\nSucesfully Done\n"+SBJ+" Range Set Is "+pmp+" <-+->"+pmf+"");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nUpdation Of Margins/Range Of "+SBJ+" Errored");
            }
        }

    }//GEN-LAST:event_FFCATSActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int cl =JOptionPane.showConfirmDialog(this,"Close Mrk","Muruaki H.S Management System", JOptionPane.YES_NO_OPTION);
        if (cl==JOptionPane.YES_OPTION) {
            System.exit(0);
        }/*else{
            return;
        }*/
        if (cl==JOptionPane.NO_OPTION) {
            remove(cl);
        }
    }//GEN-LAST:event_formWindowClosing

    private void PFSortaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PFSortaActionPerformed
        // TODO add your handling code here:
        Lasta();

        if (PasFail.getSelectedIndex()==0) {
            TbChs="tbl_MarkP";
            try {
                if (SbjBox.getSelectedIndex()==0) {
                    String sql="SELECT Name,Reg_No,Stream,Mathematics,English,Kiswahili,English,Kiswahili,Chemistry,Biology,Physics,Geography,History,CRE,Business,Agriculture FROM "+lst+" WHERE `Class`= '"+tbl+"'";
                    pst= (PreparedStatement) Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    SrtRes.setModel(DbUtils.resultSetToTableModel(rs));
                }
                else if (SbjBox.getSelectedIndex()>0) {
                    Comp();
                    String curr=SbjBox.getSelectedItem().toString(),Suj="Subject -";
                    String sql="SELECT `Name`,`Reg_No`,`Stream`,`"+curr+"` AS '"+Suj+""+curr+"'  FROM "+lst+" WHERE `Class`= '"+tbl+"' AND `"+curr+"` >="+mrk+"";
                    pst= (PreparedStatement) Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    SrtRes.setModel(DbUtils.resultSetToTableModel(rs));
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nPass Exams Section Error");
            }
        }
        if (PasFail.getSelectedIndex()==1){
            TbChs="tbl_MarkF";
            Comp();
            try {
                if (SbjBox.getSelectedIndex()==0) {
                    String sql="SELECT Name,Reg_No,Stream,Mathematics,English,Kiswahili,English,Kiswahili,Chemistry,Biology,Physics,Geography,History,CRE,Business,Agriculture FROM "+lst+" WHERE `Class`= '"+tbl+"'";
                    pst= (PreparedStatement) Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    SrtRes.setModel(DbUtils.resultSetToTableModel(rs));
                }
                else if (SbjBox.getSelectedIndex()>0) {
                    String curr=SbjBox.getSelectedItem().toString(),Suj="Subject -";
                    String sql="SELECT "+lst+".`Name`,"+lst+".`Reg_No`,"+lst+".`Stream`,"+lst+".`"+curr+"` AS '"+Suj+""+curr+"',`tbl_MarkF`."+curr+" AS FailMark  FROM "+lst+",`tbl_MarkF` WHERE "+lst+".`Class`= '"+tbl+"' AND "+lst+".`"+curr+"` >`tbl_MarkF`.`"+curr+"`";
                    pst= (PreparedStatement) Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    SrtRes.setModel(DbUtils.resultSetToTableModel(rs));
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nFailed Exams Section Error");
            }
        }
        if (PasFail.getSelectedIndex()==2){
            try {
                if (SbjBox.getSelectedIndex()==0) {
                    try {
                        String su="Mathematics";
                        String sql="SELECT "+lst+".Name,"+lst+".Stream,"+lst+".Reg_No,"+lst+"."+su+",tbl_MarkP."+su+" AS PassMark,tbl_MarkF."+su+" AS LowMark FROM "+lst+",`tbl_MarkP`,`tbl_MarkF` WHERE `"+lst+"`.`Class`= '"+tbl+"' ";//AND `tbl_MarkP`.Term="Term 3"
                        pst=(PreparedStatement) Conn.prepareStatement(sql);
                        rs=pst.executeQuery();
                        SrtRes.setModel(DbUtils.resultSetToTableModel(rs));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e+"\nNigga Mode 3");
                    }
                }else if (SbjBox.getSelectedIndex()>0){
                    try {
                        String su=SbjBox.getSelectedItem().toString();
                        String sql="SELECT "+lst+".Name,"+lst+".Stream,"+lst+".Reg_No,"+lst+"."+su+",tbl_MarkP."+su+" AS PassMark,tbl_MarkF."+su+" AS LowMark FROM "+lst+",`tbl_MarkP`,`tbl_MarkF` WHERE `"+lst+"`.`Class`= '"+tbl+"' ";//AND `tbl_MarkP`.Term="Term 3"
                        pst=(PreparedStatement) Conn.prepareStatement(sql);
                        rs=pst.executeQuery();
                        SrtRes.setModel(DbUtils.resultSetToTableModel(rs));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e+"\nNigga Mode 3");
                    }
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nDisp Error Fail Sect");
            }
        }
    }//GEN-LAST:event_PFSortaActionPerformed

    private void FltPrfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FltPrfActionPerformed
        // TODO add your handling code here:
        Nm();
        String tcl=null,tsbj=null;
        tsbj=SOmo.getSelectedItem().toString();
        int kk,ll;
        String sb=null,nom,nom2,tbx1,tbx2;
        tbx1=Ex1Perf.getSelectedItem().toString();
        tbx2=Ex2Perf.getSelectedItem().toString();
        Ex2Perf.setEnabled(Boolean.TRUE);
        
                            /*String bd = " ";
                    String gd = "_";
                    Pattern pt1 = Pattern.compile(bd);
                    Matcher m1 = pt1.matcher(tbx1);
                    Matcher m2 = pt1.matcher(tbx2); 
                    tbx1 = m1.replaceAll(gd);  
                    tbx2 = m1.replaceAll(gd);  
                    //JOptionPane.showMessageDialog(null, "Table 1 ->"+tbx1+"\nTable 2 ->"+tbx2);*/
        
            kk=SOmo.getSelectedIndex();
            ll=Clss.getSelectedIndex();
            if (ll==0) {
                sb="Form1";
            }
            if (ll==1) {
                sb="Form2";
            }
            if (ll==2) {
                sb="Form3";
            }
            if (ll==3) {
                sb="Form4";
            }

            nom=tsbj+lst;
            nom2=tsbj+lst2;
        
        if (FltPrf.getSelectedIndex()==0) {

            //lst=tbx1;lst2=tbx2;
            //JOptionPane.showMessageDialog(null, "Table 1 ->"+lst+"\nTable 2 ->"+lst2);

            try {
                //String sql="SELECT COALESCE("+lst+".Name) as Name,COALESCE("+lst+".Class) as Class,COALESCE("+lst+".Reg_No) as Reg_No,"+lst+"."+tsbj+","+lst2+"."+tsbj+" FROM "+lst+","+lst2+" WHERE ( "+lst+".Reg_No="+lst2+".Reg_No AND "+lst+".Class='"+sb+"')";
                String sql="SELECT COALESCE("+lst+".Name) as Name,COALESCE("+lst+".Reg_No) as Reg_No,("+lst+"."+tsbj+")AS "+nom+",("+lst2+"."+tsbj+")AS "+nom2+",("+lst+"."+tsbj+"-"+lst2+"."+tsbj+") AS VAP FROM "+lst+","+lst2+"  WHERE ( "+lst+".Reg_No="+lst2+".Reg_No AND "+lst+".Class='"+sb+"')";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                Niggatbl.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nNigga");
            }
        }
        
        if (FltPrf.getSelectedIndex()==1) {
            Ex2Perf.setEnabled(Boolean.FALSE);
            try {
                String sql="SELECT `Name`,`Reg_No`,`"+tsbj+"` FROM "+tbx1+"  WHERE `Class`='"+sb+"' ORDER BY `"+tsbj+"` DESC";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                Niggatbl.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nNigga");
            }
        }
        
        if (FltPrf.getSelectedIndex()==1) {
            
        }
    }//GEN-LAST:event_FltPrfActionPerformed

    private void TvwRadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TvwRadActionPerformed
        // TODO add your handling code here:
        Trm1.setEnabled(Boolean.FALSE);
        Trm2.setEnabled(Boolean.FALSE);
        Trm3.setEnabled(Boolean.FALSE);
        Cts.setEnabled(Boolean.FALSE);
        Mts.setEnabled(Boolean.FALSE);
        Ets.setEnabled(Boolean.FALSE);
        GenSvw.setEnabled(Boolean.FALSE);
        Classe1.setEnabled(Boolean.FALSE);

        GenTvw.setEnabled(Boolean.TRUE);
        TvwLst.setEnabled(Boolean.TRUE);
    }//GEN-LAST:event_TvwRadActionPerformed

    private void SvwRadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SvwRadActionPerformed
        // TODO add your handling code here:
        Trm1.setEnabled(Boolean.TRUE);
        Trm2.setEnabled(Boolean.TRUE);
        Trm3.setEnabled(Boolean.TRUE);
        Cts.setEnabled(Boolean.TRUE);
        Mts.setEnabled(Boolean.TRUE);
        Ets.setEnabled(Boolean.TRUE);

        GenTvw.setEnabled(Boolean.FALSE);
        TvwLst.setEnabled(Boolean.FALSE);
        GenSvw.setEnabled(Boolean.TRUE);
        Classe1.setEnabled(Boolean.TRUE);
    }//GEN-LAST:event_SvwRadActionPerformed

    private void GenSvwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenSvwActionPerformed
        // TODO add your handling code here:
        int hy=cc.get(Calendar.YEAR);
        String df=null,fg=null,hj=null,jk;

        if (Classe1.getSelectedIndex()==0) {
            fg="Form1";
        } else if (Classe1.getSelectedIndex()==1) {
            fg="Form2";
        }else if (Classe1.getSelectedIndex()==2) {
            fg="Form3";
        }else if (Classe1.getSelectedIndex()==3) {
            fg="Form4";
        }
        
        if (Trm1.isSelected()) {
            df="Term1";
        }
        if (Trm2.isSelected()) {
            df="Term2";
        }
        if (Trm3.isSelected()) {
            df="Term3";
        }
        
        if (Cts.isSelected()) {
            hj="CATS";
        }
        if (Mts.isSelected()) {
            hj="Mid_Term";
        }
        if (Ets.isSelected()) {
            hj="End_Term";
        }
        //2017_End_Term_Term2
        jk=hy+"_"+hj+"_"+df;
        JOptionPane.showMessageDialog(null, jk);
        rEDA();
    }//GEN-LAST:event_GenSvwActionPerformed

    private void GenTvwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenTvwActionPerformed
        // TODO add your handling code here:
        rEDA();
    }//GEN-LAST:event_GenTvwActionPerformed

    private void WrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WrtActionPerformed
        // TODO add your handling code here:
        try {
            ///media/niccher/Bookies/Ap/Coding Theory/3/MuruakyLiSynv2.0/Nigga.csv
            JOptionPane.showMessageDialog(null,Makk);
            //BufferedReader br=new BufferedReader(new FileReader(lst+".csv"));
            BufferedReader br=new BufferedReader(new FileReader(Makk));
            String ln,TBchs;
            //TBchs="Sample";
            TBchs=uPtBL.getSelectedItem().toString();
            while ((ln=br.readLine())!=null) {
                String []vls=ln.split(",");
                String sql="INSERT INTO  `"+TBchs+"` (Count,Name,Class,Reg_No,Stream,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,History,CRE,Business,Agriculture) VALUES ('"+vls[0]+"','"+vls[1]+"','"+vls[2]+"','"+vls[3]+"','"+vls[4]+"',"
                + "'"+vls[5]+"','"+vls[6]+"','"+vls[7]+"','"+vls[8]+"','"+vls[9]+"','"+vls[10]+"','"+vls[11]+"'"
                + ",'"+vls[12]+"','"+vls[13]+"','"+vls[14]+"','"+vls[15]+"')";
                pst= (PreparedStatement) Conn.prepareStatement(sql);
                pst.executeUpdate();
            }
            JOptionPane.showMessageDialog(null,"Done");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e+"\nFailedd");
        }
    }//GEN-LAST:event_WrtActionPerformed

    private void GenRepoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenRepoActionPerformed
        // TODO add your handling code here:
        try {
            String locc="/media/niccher/Bookies/Ap/Coding Theory/3/Muruaky3.0/src/v3/ThisX.jrxml";
            JasperDesign jd=JRXmlLoader.load(locc);
            String sq="SELECT * FROM "+lst+"";
            JRDesignQuery nq=new JRDesignQuery();
            nq.setText(sq);
            jd.setQuery(nq);//
            JasperReport jas=JasperCompileManager.compileReport(jd);
            JasperPrint jprn=JasperFillManager.fillReport(jas, null, Conn);
            JasperViewer.viewReport(jprn);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nJasper Error");
        }
    }//GEN-LAST:event_GenRepoActionPerformed

    private void JrXmGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JrXmGenActionPerformed
        // TODO add your handling code here:
        Nm();
        Tbll=lst;
        String pc=null;

        if (RepoClas.getSelectedIndex()==0) {
            pc="Form1";
        }
        if (RepoClas.getSelectedIndex()==1) {
            pc="Form2";
        }
        if (RepoClas.getSelectedIndex()==2) {
            pc="Form3";
        }
        if (RepoClas.getSelectedIndex()==3) {
            pc="Form4";
        }
        
        if (RepoEX.getSelectedIndex()==0) {
            Tem="CATS";
        }
        if (RepoEX.getSelectedIndex()==1) {
            Tem="Mid_Term";
        }
        if (RepoEX.getSelectedIndex()==2) {
            Tem="End_Term";
        }
        
        if (RepoTrm1.isSelected()) {
            mck="Term 1";
        }else if (RepoTrm2.isSelected()) {
            mck="Term 2";
        }else if (RepoTrm3.isSelected()) {
            mck="Term 3";
        }
        
        try {
            int ro=RepoTbl.getSelectedRow();
            String otrow=(RepoTbl.getModel().getValueAt(ro, 1).toString());
            String Nm=(RepoTbl.getModel().getValueAt(ro, 0).toString());
            String sav="SELECT * FROM `"+Tbll+"` WHERE `Reg_No`= ' "+otrow+" '";
            pst=(PreparedStatement) Conn.prepareStatement(sav);
            rs=pst.executeQuery();

            //JOptionPane.showMessageDialog(null, otrow);

            try {
                // TODO add your handling code here:
                Document recpt=new Document();
                try {
                    PdfWriter.getInstance(recpt, new FileOutputStream(("Muruaki_"+Nm+".pdf")));
                    //JOptionPane.showMessageDialog(null, "PdF Made");
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex+"File Creation Error");
                }
                recpt.open();
                /*try {
                    Image logoo=Image.getInstance("Modes.png");
                    recpt.add(new Paragraph("Logo Here"));
                    recpt.add((Element) logoo);
                } catch (BadElementException ex) {
                    JOptionPane.showMessageDialog(null, ex+"\n"+"Image Error");
                }*/
                String fch="SELECT * FROM `"+Tbll+"` WHERE `Reg_No`= ' "+otrow+" '";
                pst=(PreparedStatement) Conn.prepareStatement(fch);
                rs=pst.executeQuery();
                if (rs.next()) {
                    mth=rs.getInt("Mathematics");
                    eng=rs.getInt("English");
                    ksw=rs.getInt("Kiswahili");
                    chm=rs.getInt("Chemistry");
                    bio=rs.getInt("Biology");
                    phy=rs.getInt("Physics");
                    geo=rs.getInt("Geography");
                    cre=rs.getInt("CRE");
                    hist=rs.getInt("History");
                    biz=rs.getInt("Business");
                    agr=rs.getInt("Agriculture");
                }

                PdfPTable ptabl=new PdfPTable(3);
                PdfPCell PCell2=new PdfPCell(new Paragraph("MURUAKI HIGH SCHOOL",FontFactory.getFont(FontFactory.TIMES_BOLD,26,Font.BOLD,BaseColor.DARK_GRAY)));
                PdfPCell PCell3=new PdfPCell(new Paragraph("EXAM DEPARTMENT",FontFactory.getFont(FontFactory.HELVETICA,20,Font.BOLD,BaseColor.BLACK)));
                PdfPCell PCell4=new PdfPCell(new Paragraph("Form----"+pc+"\nExam-----"+Tem+"\n Term-----"+mck+"\n",FontFactory.getFont(FontFactory.COURIER,26,Font.BOLD,BaseColor.BLACK)));
                PdfPCell PCell=new PdfPCell(new Paragraph("Student Name----"+Nm+"\nRegistration No-----"+otrow+"",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.BLACK)));
                PCell.setColspan(5);
                PCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                PCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                PCell2.setColspan(6);
                PCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                PCell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
                PCell3.setColspan(5);
                PCell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                PCell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
                PCell4.setColspan(5);
                PCell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                PCell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
                ptabl.addCell(PCell2);
                ptabl.addCell(PCell3);
                ptabl.addCell(PCell4);
                ptabl.addCell(PCell);
                recpt.add(ptabl);
                //recpt.add(new Paragraph("----------------------------------------"));
                PdfPTable ptablR=new PdfPTable(4);

                PdfPCell PCellM=new PdfPCell(new Paragraph("Mathematics  \t\t\t\t "+mth,FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.ITALIC,BaseColor.DARK_GRAY)));
                PCellM.setColspan(6);
                //PCellM.setHorizontalAlignment(Element.ALIGN_LEFT);
                PCellM.setBackgroundColor(BaseColor.GRAY);

                PdfPCell PCellE=new PdfPCell(new Paragraph("English  \t\t\t\t "+eng,FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.ITALIC,BaseColor.DARK_GRAY)));
                PCellE.setColspan(6);
                //PCellE.setHorizontalAlignment(Element.ALIGN_LEFT);
                PCellE.setBackgroundColor(BaseColor.GRAY);

                PdfPCell PCellK=new PdfPCell(new Paragraph("Kiswahili  \t\t\t\t "+ksw,FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.ITALIC,BaseColor.DARK_GRAY)));
                PCellK.setColspan(6);
                PCellK.setHorizontalAlignment(Element.ALIGN_LEFT);
                PCellK.setBackgroundColor(BaseColor.GRAY);

                PdfPCell PCellCh=new PdfPCell(new Paragraph("Chemistry  \t\t\t\t "+chm,FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.ITALIC,BaseColor.DARK_GRAY)));
                PCellCh.setColspan(6);
                PCellCh.setHorizontalAlignment(Element.ALIGN_LEFT);
                PCellCh.setBackgroundColor(BaseColor.GRAY);

                PdfPCell PCellBio=new PdfPCell(new Paragraph("Biology  \t\t\t\t "+bio,FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.ITALIC,BaseColor.DARK_GRAY)));
                PCellBio.setColspan(6);
                PCellBio.setHorizontalAlignment(Element.ALIGN_LEFT);
                PCellBio.setBackgroundColor(BaseColor.GRAY);

                PdfPCell PCellPhy=new PdfPCell(new Paragraph("Physics  \t\t\t\t "+phy,FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.ITALIC,BaseColor.DARK_GRAY)));
                PCellPhy.setColspan(6);
                PCellPhy.setHorizontalAlignment(Element.ALIGN_LEFT);
                PCellPhy.setBackgroundColor(BaseColor.GRAY);

                PdfPCell PCellG=new PdfPCell(new Paragraph("Geography  \t\t\t\t "+geo,FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.ITALIC,BaseColor.DARK_GRAY)));
                PCellG.setColspan(6);
                PCellG.setHorizontalAlignment(Element.ALIGN_LEFT);
                PCellG.setBackgroundColor(BaseColor.GRAY);
                
                PdfPCell PCellHist=new PdfPCell(new Paragraph("History  \t\t\t\t "+hist,FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.ITALIC,BaseColor.DARK_GRAY)));
                PCellHist.setColspan(6);
                PCellHist.setHorizontalAlignment(Element.ALIGN_LEFT);
                PCellHist.setBackgroundColor(BaseColor.GRAY);
                
                PdfPCell PCellCre=new PdfPCell(new Paragraph("CRE  \t\t\t\t "+cre,FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.ITALIC,BaseColor.DARK_GRAY)));
                PCellCre.setColspan(6);
                PCellCre.setHorizontalAlignment(Element.ALIGN_LEFT);
                PCellCre.setBackgroundColor(BaseColor.GRAY);
                
                PdfPCell PCellaGR=new PdfPCell(new Paragraph("Agriculture  \t\t\t\t "+agr,FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.ITALIC,BaseColor.DARK_GRAY)));
                PCellaGR.setColspan(6);
                PCellaGR.setHorizontalAlignment(Element.ALIGN_LEFT);
                PCellaGR.setBackgroundColor(BaseColor.GRAY);
                
                PdfPCell PCellBus=new PdfPCell(new Paragraph("Business  \t\t\t\t "+biz,FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.ITALIC,BaseColor.DARK_GRAY)));
                PCellBus.setColspan(6);
                PCellBus.setHorizontalAlignment(Element.ALIGN_LEFT);
                PCellBus.setBackgroundColor(BaseColor.GRAY);

                PdfPCell PCellt=new PdfPCell(new Paragraph("Result Slip,Printed As At\t\t"+new java.util.Date().toString(),FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.ITALIC,BaseColor.DARK_GRAY)));
                PCellt.setColspan(6);
                PCellt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                PCellt.setBackgroundColor(BaseColor.CYAN);

                ptablR.addCell(PCellM);
                ptablR.addCell(PCellE);
                ptablR.addCell(PCellK);
                ptablR.addCell(PCellCh);
                ptablR.addCell(PCellBio);
                ptablR.addCell(PCellPhy);
                ptablR.addCell(PCellG);
                ptablR.addCell(PCellHist);
                ptablR.addCell(PCellCre);
                ptablR.addCell(PCellaGR);
                ptablR.addCell(PCellBus);
                ptablR.addCell(PCellt);

                recpt.add(ptablR);

                ptabl.addCell(PCell);
                /*ptabl.addCell("Cell1");
                ptabl.addCell("Cell2");
                ptabl.addCell("Cell3");*/
                //recpt.add(ptabl);
                com.itextpdf.text.List lst=new com.itextpdf.text.List(true,4);
                /*lst.add(" List 01");
                lst.add(" List 02");
                lst.add(" List 03");*/
                recpt.add(lst);
                recpt.close();
                JOptionPane.showMessageDialog(null, "Data Feed Complete");
                String msg="<html>";
            } catch (DocumentException ex) {
                JOptionPane.showMessageDialog(null, ex+"PDF Data Feed Error");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nGet Selected Row Error");
        }
    }//GEN-LAST:event_JrXmGenActionPerformed

    private void VwCredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VwCredActionPerformed
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, lst);
        String csa=null,sq=null;
        if (RepoClas.getSelectedIndex()==0) {
            csa="Form1";
        }
        if (RepoClas.getSelectedIndex()==1) {
            csa="Form2";
        }
        if (RepoClas.getSelectedIndex()==02) {
            csa="Form3";
        }
        if (RepoClas.getSelectedIndex()==03) {
            csa="Form4";
        }
        try {
            String locc="/media/niccher/Bookies/Ap/Coding Theory/3/Muruaky3.0/src/v3/ClassAll.jrxml";
            JasperDesign jd=JRXmlLoader.load(locc);
            //lst="Name Class Reg_No Mathematics English Kiswahili Chemistry Biology Physics Geography History CRE Business Agriculture";
            /*sq="SELECT Name,Class,Reg_No,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,History,CRE,Business,Agriculture FROM "+lst+" WHERE Class="+csa+" ";
            JRDesignQuery nq=new JRDesignQuery();
            nq.setText(sq);
            jd.setQuery(nq);*/
            JasperReport jas=JasperCompileManager.compileReport(jd);
            JasperPrint jprn=JasperFillManager.fillReport(jas, null, Conn);
            JasperViewer.viewReport(jprn,Boolean.FALSE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nJasper Error\n"+csa+"\n"+sq);
        }
    }//GEN-LAST:event_VwCredActionPerformed

    private void SyncRepoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SyncRepoActionPerformed
        // TODO add your handling code here:
        String et,fll,trm;
        Calendar cl=new GregorianCalendar();
        int Y=cl.get(Calendar.YEAR);
        et=RepoEX.getSelectedItem().toString();
        fll=RepoClas.getSelectedItem().toString();
        //2018_CATS_Term2_Form2 CATS, Mid-Term, End-Term
        /*if (et=="CATS") {
            mck="CATS";
        }else if (et=="Mid-Term") {
            mck="Mid_Term";
        }else if (et=="End-Term") {
            mck="End_Term";
        }
        if (RepoTrm1.isSelected()) {
            Tem="Term1";
        }
        else if (RepoTrm2.isSelected()) {
            Tem="Term2";
            //JOptionPane.showMessageDialog(null, Tem);
        }
        else if (RepoTrm3.isSelected()) {
            Tem="Term3";
        }
        Tbll=String.valueOf(Y)+"_"+mck+"_"+Tem+"_"+pc;*/
        Nm();
        Tbll=lst;
        String pc=null;

        if (RepoClas.getSelectedIndex()==0) {
            pc="Form1";
        }
        if (RepoClas.getSelectedIndex()==1) {
            pc="Form2";
        }
        if (RepoClas.getSelectedIndex()==2) {
            pc="Form3";
        }
        if (RepoClas.getSelectedIndex()==3) {
            pc="Form4";
        }
        
        if (RepoEX.getSelectedIndex()==0) {
            Tem="CATS";
        }
        if (RepoEX.getSelectedIndex()==1) {
            Tem="Mid_Term";
        }
        if (RepoEX.getSelectedIndex()==2) {
            Tem="End_Term";
        }
        
        if (RepoTrm1.isSelected()) {
            mck="Term 1";
        }else if (RepoTrm2.isSelected()) {
            mck="Term 2";
        }else if (RepoTrm3.isSelected()) {
            mck="Term 3";
        }
        
        if (pc=="Form3" || pc=="Form4") {
            try {
                Makeit();
                String cops="SELECT Name,Reg_No,Stream,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,CRE,Business,Agriculture FROM "+Tbll+" WHERE (`Class`='"+pc+"' )";
                pst=(PreparedStatement) Conn.prepareStatement(cops);
                rs=pst.executeQuery();
                RepoTbl.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nAction Not Allowed Please");
            }
            
        }else{
            try {
                String cops="SELECT Name,Reg_No,Stream,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,CRE,Business,Agriculture FROM "+Tbll+" WHERE (`Class`='"+pc+"' )";
                pst=(PreparedStatement) Conn.prepareStatement(cops);
                rs=pst.executeQuery();
                RepoTbl.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nAction Not Allowed Please");
            }
        }
    }//GEN-LAST:event_SyncRepoActionPerformed

    private void MprntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MprntActionPerformed
        // TODO add your handling code here:
        Tbll=lst;
        String pc=null;

                if (RepoClas.getSelectedIndex()==0) {
            pc="Form1";
        }
        if (RepoClas.getSelectedIndex()==1) {
            pc="Form2";
        }
        if (RepoClas.getSelectedIndex()==2) {
            pc="Form3";
        }
        if (RepoClas.getSelectedIndex()==3) {
            pc="Form4";
        }
        
        if (RepoEX.getSelectedIndex()==0) {
            Tem="CATS";
        }
        if (RepoEX.getSelectedIndex()==1) {
            Tem="Mid_Term";
        }
        if (RepoEX.getSelectedIndex()==2) {
            Tem="End_Term";
        }
        
        if (RepoTrm1.isSelected()) {
            mck="Term 1";
        }else if (RepoTrm2.isSelected()) {
            mck="Term 2";
        }else if (RepoTrm3.isSelected()) {
            mck="Term 3";
        }
        try {
            /*String lope="SELECT `Reg_No` FROM `"+Tbll+"`";
            pst=conn.prepareStatement(lope);
            rs=pst.executeQuery();*/
            //while (rs.next()) {
                //int ch=rs.getInt("Reg_No");
                try {
                    int ro=RepoTbl.getSelectedRow();
                    int ca=RepoTbl.getRowCount();
                    int mka=cc.get(Calendar.YEAR);
                    JOptionPane.showMessageDialog(null, ca);
                    for (int i = 0; i < RepoTbl.getRowCount()+2; i++) {
                        String otrow=(RepoTbl.getModel().getValueAt(i, 2).toString());
                        String Nm=(RepoTbl.getModel().getValueAt(i, 1).toString());
                        String sav2="SELECT * FROM `"+Tbll+"` WHERE `Reg_No`= ' "+otrow+" '";
                        String sav="SELECT * FROM `tbl_markP` WHERE `Year`= "+mka+" ";
                        pst=(PreparedStatement) Conn.prepareStatement(sav2);
                        rs=pst.executeQuery();
                        try {
                            // TODO add your handling code here:
                            Document recpt=new Document();
                            PdfWriter.getInstance(recpt, new FileOutputStream(("Muruaki_"+Nm+".pdf")));
                            recpt.open();
                            /*try {
                                Image logoo=Image.getInstance("Modes.png");
                                recpt.add(new Paragraph("Logo Here"));
                                recpt.add((Element) logoo);
                            } catch (BadElementException ex) {
                                JOptionPane.showMessageDialog(null, ex+"\n"+"Image Error");
                            }*/

                            String fch="SELECT * FROM `"+Tbll+"` WHERE `Reg_No`= ' "+otrow+" '";
                            pst=(PreparedStatement) Conn.prepareStatement(fch);
                            rs=pst.executeQuery();
                            if (rs.next()) {
                                mth=rs.getInt("Mathematics");
                                eng=rs.getInt("English");
                                ksw=rs.getInt("Kiswahili");
                                chm=rs.getInt("Chemistry");
                                bio=rs.getInt("Biology");
                                phy=rs.getInt("Physics");
                                geo=rs.getInt("Geography");
                                cre=rs.getInt("CRE");
                                hist=rs.getInt("History");
                                biz=rs.getInt("Mathematics");
                                agr=rs.getInt("Mathematics");
                            }

                            PdfPTable ptabl=new PdfPTable(3);
                            PdfPCell PCell2=new PdfPCell(new Paragraph("MURUAKI HIGH SCHOOL",FontFactory.getFont(FontFactory.TIMES_BOLD,26,Font.BOLD,BaseColor.DARK_GRAY)));
                            PdfPCell PCell3=new PdfPCell(new Paragraph("EXAM DEPARTMENT",FontFactory.getFont(FontFactory.HELVETICA,20,Font.BOLD,BaseColor.BLACK)));
                            PdfPCell PCell4=new PdfPCell(new Paragraph("Form----"+pc+"\n Exam-----"+mck+"\n Term-----"+Tem+"\n",FontFactory.getFont(FontFactory.COURIER,26,Font.BOLD,BaseColor.BLACK)));
                            PdfPCell PCell=new PdfPCell(new Paragraph("Student Name----"+Nm+"\n Registration No-----"+otrow+"",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.BLACK)));
                            PCell.setColspan(5);
                            PCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            PCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                            PCell2.setColspan(6);
                            PCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                            PCell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
                            PCell3.setColspan(5);
                            PCell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                            PCell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
                            PCell4.setColspan(5);
                            PCell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                            PCell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
                            ptabl.addCell(PCell2);
                            ptabl.addCell(PCell3);
                            ptabl.addCell(PCell4);
                            ptabl.addCell(PCell);
                            recpt.add(ptabl);
                            //recpt.add(new Paragraph("----------------------------------------"));

                            PdfPTable ptablR=new PdfPTable(4);

                            PdfPCell PCellM=new PdfPCell(new Paragraph("Mathematics  \t\t\t\t "+mth,FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.ITALIC,BaseColor.DARK_GRAY)));
                            PCellM.setColspan(6);
                            //PCellM.setHorizontalAlignment(Element.ALIGN_LEFT);
                            PCellM.setBackgroundColor(BaseColor.PINK);

                            PdfPCell PCellE=new PdfPCell(new Paragraph("English  \t\t\t\t "+eng,FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.ITALIC,BaseColor.DARK_GRAY)));
                            PCellE.setColspan(6);
                            //PCellE.setHorizontalAlignment(Element.ALIGN_LEFT);
                            PCellE.setBackgroundColor(BaseColor.PINK);

                            PdfPCell PCellK=new PdfPCell(new Paragraph("Kiswahili  \t\t\t\t "+ksw,FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.ITALIC,BaseColor.DARK_GRAY)));
                            PCellK.setColspan(6);
                            PCellK.setHorizontalAlignment(Element.ALIGN_LEFT);
                            PCellK.setBackgroundColor(BaseColor.PINK);

                            PdfPCell PCellCh=new PdfPCell(new Paragraph("Chemistry  \t\t\t\t "+chm,FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.ITALIC,BaseColor.DARK_GRAY)));
                            PCellCh.setColspan(6);
                            PCellCh.setHorizontalAlignment(Element.ALIGN_LEFT);
                            PCellCh.setBackgroundColor(BaseColor.PINK);

                            PdfPCell PCellBio=new PdfPCell(new Paragraph("Biology  \t\t\t\t "+bio,FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.ITALIC,BaseColor.DARK_GRAY)));
                            PCellBio.setColspan(6);
                            PCellBio.setHorizontalAlignment(Element.ALIGN_LEFT);
                            PCellBio.setBackgroundColor(BaseColor.GRAY);

                            PdfPCell PCellPhy=new PdfPCell(new Paragraph("Physics  \t\t\t\t "+phy,FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.ITALIC,BaseColor.DARK_GRAY)));
                            PCellPhy.setColspan(6);
                            PCellPhy.setHorizontalAlignment(Element.ALIGN_LEFT);
                            PCellPhy.setBackgroundColor(BaseColor.GRAY);

                            PdfPCell PCellG=new PdfPCell(new Paragraph("Geography  \t\t\t\t "+geo,FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.ITALIC,BaseColor.DARK_GRAY)));
                            PCellG.setColspan(6);
                            PCellG.setHorizontalAlignment(Element.ALIGN_LEFT);
                            PCellG.setBackgroundColor(BaseColor.GRAY);

                            PdfPCell PCellt=new PdfPCell(new Paragraph("Result Slip,Printed As At\t\t"+new java.util.Date().toString(),FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.ITALIC,BaseColor.DARK_GRAY)));
                            PCellt.setColspan(6);
                            PCellt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                            PCellt.setBackgroundColor(BaseColor.CYAN);

                            ptablR.addCell(PCellM);
                            ptablR.addCell(PCellE);
                            ptablR.addCell(PCellK);
                            ptablR.addCell(PCellCh);
                            ptablR.addCell(PCellBio);
                            ptablR.addCell(PCellPhy);
                            ptablR.addCell(PCellG);
                            ptablR.addCell(PCellt);

                            recpt.add(ptablR);

                            ptabl.addCell(PCell);
                            /*ptabl.addCell("Cell1");
                            ptabl.addCell("Cell2");
                            ptabl.addCell("Cell3");*/
                            //recpt.add(ptabl);
                            com.itextpdf.text.List lst=new com.itextpdf.text.List(true,4);
                            /*lst.add(" List 01");
                            lst.add(" List 02");
                            lst.add(" List 03");*/
                            recpt.add(lst);
                            recpt.close();
                            //JOptionPane.showMessageDialog(null, "Data Feed Complete");
                            String msg="<html>";
                        } catch (DocumentException ex) {
                            JOptionPane.showMessageDialog(null, ex+"PDF Data Feed Error");
                        }
                    }
                } catch (Exception e) {
                    //JOptionPane.showMessageDialog(null, e+"\nGet Selected Row Error");
                }
                //}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"Looping Error");
        }
    }//GEN-LAST:event_MprntActionPerformed

    private void SClsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SClsActionPerformed
        // TODO add your handling code here:

        if(AddF1.isSelected()){
            Fm="Form1";
            Fmm=1;
            if(AddF1N.isSelected()){
                F1n=1;
                Str="North";
                Mng();
            }
            if(AddF1S.isSelected()){
                F1s=1;
                Str="South";
                Mng();
            }
            if(AddF1W.isSelected()){
                F1w=1;
                Str="West";
                Mng();
            }
            if(AddF1E.isSelected()){
                F1e=1;
                Str="East";
                Mng();
            }
            JOptionPane.showMessageDialog(null, "Done Setting For "+Fm);
        }

        if(AddF2.isSelected()){
            Fm="Form2";
            Fmm=2;
            if(AddF2N.isSelected()){
                F2n=1;
                Str="North";
                Mng();
            }
            if(AddF2S.isSelected()){
                F2s=1;
                Str="South";
                Mng();
            }
            if(AddF2E.isSelected()){
                F2e=1;
                Str="East";
                Mng();
            }
            if(AddF2W.isSelected()){
                F2w=1;
                Str="West";
                Mng();
            }
            JOptionPane.showMessageDialog(null, "Done Setting For "+Fm);
        }

        if(AddF3.isSelected()){
            Fm="Form3";
            Fmm=3;
            if(AddF3N.isSelected()){
                F3n=1;
                Str="North";
                Mng();
            }
            if(AddF3S.isSelected()){
                F3s=1;
                Str="South";
                Mng();
            }
            if(AddF3E.isSelected()){
                F3e=1;
                Str="East";
                Mng();
            }
            if(AddF3W.isSelected()){
                F3w=1;
                Str="West";
                Mng();
            }
            JOptionPane.showMessageDialog(null, "Done Setting For "+Fm);
        }

        if(AddF4.isSelected()){
            Fm="Form4";
            Fmm=4;
            if(AddF4S.isSelected()){
                F4s=1;
                Str="South";
                Mng();
            }
            if(AddF4E.isSelected()){
                F4e=1;
                Str="East";
                Mng();
            }
            if(AddF4W.isSelected()){
                F4w=1;
                Str="West";
                Mng();
            }
            if(AddF4N.isSelected()){
                F4n=1;
                Str="North";
                Mng();
            }
            JOptionPane.showMessageDialog(null, "Done Setting For "+Fm);
        }

    }//GEN-LAST:event_SClsActionPerformed

    private void AddF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddF1ActionPerformed
        // TODO add your handling code here:
        Slepa();
    }//GEN-LAST:event_AddF1ActionPerformed

    private void AddF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddF2ActionPerformed
        // TODO add your handling code here:
        Slepa();
    }//GEN-LAST:event_AddF2ActionPerformed

    private void AddF4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddF4ActionPerformed
        // TODO add your handling code here:
        Slepa();
    }//GEN-LAST:event_AddF4ActionPerformed

    private void AddF3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddF3ActionPerformed
        // TODO add your handling code here:
        Slepa();
    }//GEN-LAST:event_AddF3ActionPerformed

    private void SncSenrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SncSenrActionPerformed
        // TODO add your handling code here:
        SenrAd();
        Nm();
        if (StrmSenrAdd.getSelectedIndex()>0) {
            snmstr=StrmSenrAdd.getSelectedItem().toString();
        }
        if (SbjSenrChus.getSelectedIndex()<4) {
            if (StrmSenrAdd.getSelectedIndex()==0) {
                try {
                    String sql="SELECT `Name`,`Reg_No`,`"+snmsbj+"` FROM "+lst+" WHERE `Class`='"+snmcls+"' ";
                    pst=(PreparedStatement) Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    SnrTblAd.setModel(DbUtils.resultSetToTableModel(rs));
                    SnrTblAd.setVisible(Boolean.TRUE);
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e+"\nNo Such Table");
                }
            }else{
                try {
                    String sql="SELECT `Name`,`Reg_No`,`"+snmsbj+"` FROM "+lst+" WHERE `Class`='"+snmcls+"' AND `Stream`= '"+snmstr+"' ";
                    pst=(PreparedStatement) Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    SnrTblAd.setModel(DbUtils.resultSetToTableModel(rs));
                    SnrTblAd.setVisible(Boolean.TRUE);
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e+"\nNo Such Table");
                }
            }
        }
        if (SbjSenrChus.getSelectedIndex()>3) {
            if (StrmSenrAdd.getSelectedIndex()==0) {
                try {
                    String sql="SELECT COALESCE("+lst+".Name) AS Name,COALESCE("+lst+".Class) AS Class,COALESCE("+lst+".Reg_No) AS Reg_No,("+lst+"."+snmsbj+") FROM "+lst+",`tbl_Placer`  WHERE ( "+lst+".Reg_No=`tbl_Placer`.Reg_No AND `tbl_Placer`."+snmsbj+"=1 AND `tbl_Placer`.`Class`= '"+snmcls+"' )";
                    pst=(PreparedStatement) Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    SnrTblAd.setModel(DbUtils.resultSetToTableModel(rs));
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e+"\nNo Such Table");
                }
            } else {
                try {
                    String sql="SELECT COALESCE("+lst+".Name) AS Name,COALESCE("+lst+".Class) AS Class,COALESCE("+lst+".Reg_No) AS Reg_No,("+lst+"."+snmsbj+") FROM "+lst+",`tbl_Placer`  WHERE ( "+lst+".Reg_No=`tbl_Placer`.Reg_No AND `tbl_Placer`."+snmsbj+"=1 AND `tbl_Placer`.`Class`= '"+snmcls+"' AND `"+lst+"`.`Stream`= '"+snmstr+"')";
                    pst=(PreparedStatement) Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    SnrTblAd.setModel(DbUtils.resultSetToTableModel(rs));
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e+"\nNo Such Table");
                }
            }
        }
        //JOptionPane.showMessageDialog(null, "Class ->"+snmcls+"\n"+"Stream ->"+snmstr+"\n"+"Subjech Choosen ->"+snmsbj);        
    }//GEN-LAST:event_SncSenrActionPerformed

    private void InsrtSenrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsrtSenrActionPerformed
        // TODO add your handling code here:
        Nm();
        DefaultTableModel tts=(DefaultTableModel) SnrTblAd.getModel();
        try {
            for(int i=0; i<SnrTblAd.getRowCount(); i++){
                String SB=snmsbj;
                float kk=Integer.parseInt(SnrTblAd.getValueAt(i, 2).toString()) ;
                int reg=Integer.parseInt(SnrTblAd.getValueAt(i, 1).toString()) ;
                String sqll="UPDATE `"+lst+"` SET "+SB+"="+kk+" WHERE Reg_No="+reg+"";
                    try {
                        pst=(PreparedStatement) Conn.prepareStatement(sqll);
                        pst.execute();
                        Toolkit.getDefaultToolkit().beep();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex+"\nUpadate Error");
                    }
            }
            //JOptionPane.showMessageDialog(null, "Subject ->"+snmsbj+"Added ->"+kk+"\n"+"Reg No ->"+reg);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nSome Errors ");
        }
        
        
        try {
            String sql="SELECT `Name`,`Reg_No`,`"+snmsbj+"` FROM `"+lst+"` WHERE `Class`='"+snmcls+"' ";
            pst=(PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            SenrConfTbl.setModel(DbUtils.resultSetToTableModel(rs));
            SenrConfTbl.setVisible(Boolean.TRUE);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nNo Such Table");
        }
    }//GEN-LAST:event_InsrtSenrActionPerformed

    private void BacSettActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BacSettActionPerformed
        // TODO add your handling code here:
        Mainn.setVisible(Boolean.FALSE);
        Sett.setVisible(Boolean.TRUE);
        Senr.setVisible(Boolean.FALSE);
    }//GEN-LAST:event_BacSettActionPerformed

    private void GrdSettActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrdSettActionPerformed
        // TODO add your handling code here:
        Nm();
        hr=Integer.parseInt(Hrange.getSelectedItem().toString());
        lr=Integer.parseInt(Lrange.getSelectedItem().toString());
        cmnt=CommBox.getText();
        Greda();
        String emh="Class ->"+frgd+"  Grade Level ->"+grd+"\nSubject ->"+sbgd+"  Range ->"+hr+"<-->"+lr+"\nComment ->"+cmnt+"\n";
        try {
            String sql="INSERT INTO `tbl_Grades` (`Count`,`Class`,`Test`,`Grade`,`Best`,`Least`,`Comment`) VALUES (NULL,'"+frgd+"','"+lst+"','"+grd+"','"+hr+"','"+lr+"','"+cmnt+"')";
            pst = (PreparedStatement) Conn.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nTable Error");
        }
        GraBox.append(emh);
    }//GEN-LAST:event_GrdSettActionPerformed

    private void ComBinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComBinActionPerformed
        // TODO add your handling code here:
        int ccl=Classe.getSelectedIndex();
        String srm=StrNxt.getSelectedItem().toString();
        Lasta();

        if (ccl==0) {
            tbl="Form1";
        }if(ccl==1){
            tbl="Form2";
        }if(ccl==2){
            tbl="Form3";
        }if(ccl==3){
            tbl="Form4";
        }

        if (ComBin.getSelectedIndex()==1) {
            try {
                if (srm=="All") {
                    String Sq="SELECT Name,Reg_No,Stream,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,History,Geography,CRE,Agriculture,Business FROM `"+lst+"` WHERE `Class`='"+tbl+"' ";
                    pst=(PreparedStatement) Conn.prepareStatement(Sq);
                    rs=pst.executeQuery();
                    Leva.setModel(DbUtils.resultSetToTableModel(rs));
                }
                else{
                    String Sq="SELECT Name,Reg_No,Stream,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,History,Geography,CRE,Agriculture,Business FROM `"+lst+"` WHERE `Class`='"+tbl+"' AND `Stream`='"+srm+"' ";
                    pst=(PreparedStatement) Conn.prepareStatement(Sq);
                    rs=pst.executeQuery();
                    Leva.setModel(DbUtils.resultSetToTableModel(rs));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nNext Level Miss"+tbl);
            }
        }
        if(ComBin.getSelectedIndex()==0) {
            try {
                /*/*/
                int Mathpass=0,Engpass=0,Kiswapass=0,Chempass=0,Biopass=0,Phypass=0,Histpass=0,Geopass=0,CREpass=0,Agricpass=0,Buspass=0;
                    
                    String TrmSdy=null,EmTy=null;
                    int Yer=cc.get(Calendar.YEAR);
                    
                    if (eXA.getText().contains("Term1")) {
                        TrmSdy="Term 1";
                    }
                    if (eXA.getText().contains("Term2")) {
                        TrmSdy="Term 2";
                    }
                    if (eXA.getText().contains("Term3")) {
                        TrmSdy="Term 3";
                    }
                    
                    if (eXA.getText().contains("CATS")) {
                        EmTy="CATS";
                    }
                    if (eXA.getText().contains("Mid")) {
                        EmTy="Mid";
                    }
                    if (eXA.getText().contains("End")) {
                        EmTy="End";
                    }
                    
                    String sav="SELECT * FROM `tbl_MarkP`  WHERE `Year`= '"+Yer+"' AND `Term`='"+TrmSdy+"' AND `EXAM`= '"+EmTy+"'";
                        pst=(PreparedStatement) Conn.prepareStatement(sav);
                        rs=pst.executeQuery();
                        if (rs.next()) {
                                Mathpass=rs.getInt("Mathematics");
                                Engpass=rs.getInt("English");
                                Kiswapass=rs.getInt("Kiswahili");
                                Chempass=rs.getInt("Chemistry");
                                Biopass=rs.getInt("Biology");
                                Phypass=rs.getInt("Physics");
                                Histpass=rs.getInt("History");
                                Geopass=rs.getInt("Geography");
                                CREpass=rs.getInt("CRE");
                                Agricpass=rs.getInt("Agriculture");
                                Buspass=rs.getInt("Business");
                        }
                /*/*/
                if (srm=="All") {
                     
                    String Sq="SELECT * FROM `"+lst+"` WHERE `Class`='"+tbl+"' AND `Mathematics`>='"+Mathpass+"' AND `English`>='"+Engpass+"' AND `Kiswahili`>='"+Kiswapass+"' AND `Chemistry`>='"+Chempass+"' AND `Biology` >='"+Biopass+"' AND `Physics`>='"+Phypass+"' AND `History`>='"+Histpass+"' AND `Geography`>='"+Geopass+"' AND `CRE`>='"+CREpass+"' AND `Agriculture`>='"+Agricpass+"' AND `Business`>='"+Buspass+"' ";
                    pst=(PreparedStatement) Conn.prepareStatement(Sq);
                    rs=pst.executeQuery();
                    Leva.setModel(DbUtils.resultSetToTableModel(rs));
                }
                else{
                    String Sq="SELECT Name,Reg_No,Stream,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,History,Geography,CRE,Agriculture,Business FROM `"+lst+"` WHERE `Class`='"+tbl+"' AND `Stream`='"+srm+"' ";
                    pst=(PreparedStatement) Conn.prepareStatement(Sq);
                    rs=pst.executeQuery();
                    Leva.setModel(DbUtils.resultSetToTableModel(rs));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nPass level init fail");
            }
        }
        if(ComBin.getSelectedIndex()==3) {
            try {
                
                int Mathfail=0,Engfail=0,Kiswafail=0,Chemfail=0,Biofail=0,Phyfail=0,Histfail=0,Geofail=0,CREfail=0,Agricfail=0,Busfail=0;
                    
                    String TrmSdy=null,EmTy=null;
                    int Yer=cc.get(Calendar.YEAR);
                    
                    if (eXA.getText().contains("Term1")) {
                        TrmSdy="Term 1";
                    }
                    if (eXA.getText().contains("Term2")) {
                        TrmSdy="Term 2";
                    }
                    if (eXA.getText().contains("Term3")) {
                        TrmSdy="Term 3";
                    }
                    
                    if (eXA.getText().contains("CATS")) {
                        EmTy="CATS";
                    }
                    if (eXA.getText().contains("Mid")) {
                        EmTy="Mid";
                    }
                    if (eXA.getText().contains("End")) {
                        EmTy="End";
                    }
                    
                    String sav="SELECT * FROM `tbl_MarkF`  WHERE `Year`= '"+Yer+"' AND `Term`='"+TrmSdy+"' AND `EXAM`= '"+EmTy+"'";
                        pst=(PreparedStatement) Conn.prepareStatement(sav);
                        rs=pst.executeQuery();
                        if (rs.next()) {
                                Mathfail=rs.getInt("Mathematics");
                                Engfail=rs.getInt("English");
                                Kiswafail=rs.getInt("Kiswahili");
                                Chemfail=rs.getInt("Chemistry");
                                Biofail=rs.getInt("Biology");
                                Phyfail=rs.getInt("Physics");
                                Histfail=rs.getInt("History");
                                Geofail=rs.getInt("Geography");
                                CREfail=rs.getInt("CRE");
                                Agricfail=rs.getInt("Agriculture");
                                Busfail=rs.getInt("Business");
                        }
                if (srm=="All") {
                     
                    String Sq="SELECT * FROM `"+lst+"` WHERE `Class`='"+tbl+"' AND `Mathematics`<='"+Mathfail+"' AND `English`<='"+Engfail+"' AND `Kiswahili`<='"+Kiswafail+"' AND `Chemistry`<='"+Chemfail+"' AND `Biology` <='"+Biofail+"' AND `Physics`<='"+Phyfail+"' AND `History`<='"+Histfail+"' AND `Geography`<='"+Geofail+"' AND `CRE`<='"+CREfail+"' AND `Agriculture`<='"+Agricfail+"' AND `Business`<='"+Busfail+"' ";
                    pst=(PreparedStatement) Conn.prepareStatement(Sq);
                    rs=pst.executeQuery();
                    Leva.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                else{
                    String Sq="SELECT Name,Reg_No,Stream,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,History,Geography,CRE,Agriculture,Business FROM `"+lst+"` WHERE `Class`='"+tbl+"' AND `Stream`='"+srm+"' ";
                    pst=(PreparedStatement) Conn.prepareStatement(Sq);
                    rs=pst.executeQuery();
                    Leva.setModel(DbUtils.resultSetToTableModel(rs));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "\nTable Missing");
            }
        }
    }//GEN-LAST:event_ComBinActionPerformed

    private void PrntRepoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrntRepoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrntRepoActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void ClasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClasseActionPerformed
        // TODO add your handling code here:
        StrNxt.setEnabled(Boolean.TRUE);
        if (Classe.getSelectedIndex()==0) {
            ClStr="Form1";
            StrNxt.removeAllItems();
            StrNx();
        }
        if (Classe.getSelectedIndex()==1) {
            ClStr="Form2";
            StrNxt.removeAllItems();
            StrNx();
        }
        if (Classe.getSelectedIndex()==2) {
            ClStr="Form3";
            StrNxt.removeAllItems();
            StrNx();
        }
    }//GEN-LAST:event_ClasseActionPerformed

    private void CsvGtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CsvGtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CsvGtActionPerformed

    private void CsvGtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CsvGtMouseClicked
        // TODO add your handling code here:
        try {
            JFileChooser prip=new JFileChooser();
            FileFilter flft=new FileNameExtensionFilter(".CSV Only", "csv");

            prip.setFileFilter(flft);
            prip.addChoosableFileFilter(flft);
            int rtn=prip.showOpenDialog(null);
            
            if (rtn==JFileChooser.APPROVE_OPTION) {
                File f= new File(prip.getSelectedFile().getAbsolutePath());//prip.getSelectedFile();
                Patt=f.getAbsolutePath();
                CsvGt.setText(Patt);
                Makk=CsvGt.getText();
            }
            
            String Parr=Patt;
            String cv=".csv";
            Pattern r = Pattern.compile(cv);

            Matcher m = r.matcher(Parr);

            
            if (m.find( )) {
               Wrt.setEnabled(Boolean.TRUE);
            } 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Null or Invalid 'Comma Separated values' File");
            Wrt.setEnabled(Boolean.FALSE);
        }
    }//GEN-LAST:event_CsvGtMouseClicked

    private void StrNxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StrNxtActionPerformed
        // TODO add your handling code here:
        if (StrNxt.getSelectedIndex()==0) {
            try {
                    String sql="SELECT * FROM `tbl_ClassList` WHERE `Class`='"+ClStr+"' ";
                    //pst=(PreparedStatement) Conn.prepareStatement(sql);
                    //rs=pst.executeQuery();
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nStr Error 22");
            }
        }
    }//GEN-LAST:event_StrNxtActionPerformed

    private void ClssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClssActionPerformed
        // TODO add your handling code here:
        if (Clss.getSelectedIndex()==0) {
            ClStr="Form1";
            StrPerf.removeAllItems();
            StrPerf();
        }
        if (Clss.getSelectedIndex()==1) {
            ClStr="Form2";
            StrPerf.removeAllItems();
            StrPerf();
        }
        if (Clss.getSelectedIndex()==2) {
            ClStr="Form3";
            StrPerf.removeAllItems();
            StrPerf();
        }
        if (Clss.getSelectedIndex()==3) {
            ClStr="Form4";
            StrPerf.removeAllItems();
            StrPerf();
        }
    }//GEN-LAST:event_ClssActionPerformed

    private void FrmSenrAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FrmSenrAddActionPerformed
        // TODO add your handling code here:
        if (FrmSenrAdd.getSelectedIndex()==0) {
            ClStr="Form3";
            StrmSenrAdd.removeAllItems();
            Chus();
        }
        if (FrmSenrAdd.getSelectedIndex()==1) {
            ClStr="Form4";
            StrmSenrAdd.removeAllItems();
            Chus();
        }
    }//GEN-LAST:event_FrmSenrAddActionPerformed

    private void KcMrk2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KcMrk2KeyTyped
        // TODO add your handling code here:
        char cc=evt.getKeyChar();
        if(!(Character.isDigit(cc) || cc==KeyEvent.VK_BACK_SPACE || cc==KeyEvent.VK_DELETE )){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_KcMrk2KeyTyped

    private void GContKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GContKeyTyped
        // TODO add your handling code here:
        char cc=evt.getKeyChar();
        if(!(Character.isDigit(cc) || cc==KeyEvent.VK_BACK_SPACE || cc==KeyEvent.VK_DELETE )){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_GContKeyTyped

    private void RgNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RgNoKeyTyped
        // TODO add your handling code here:
         char cc=evt.getKeyChar();
        if(!(Character.isDigit(cc) || cc==KeyEvent.VK_BACK_SPACE || cc==KeyEvent.VK_DELETE )){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_RgNoKeyTyped

    private void PrVwStdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrVwStdActionPerformed
        // TODO add your handling code here:
        try {
            String locc="/media/niccher/Bookies/Ap/Coding Theory/3/Muruaky3.0/src/v3/AllStudent.jrxml";
            JasperDesign jd=JRXmlLoader.load(locc);
            //String lolst="Name Class Reg_No Mathematics English Kiswahili Chemistry Biology ";//Physics Geography History CRE Business Agriculture
            String sq="SELECT Name,Surname,Reg_No,KCPE,Birth,Class,Stream,Dorm,Parent,Residence,Contact FROM `tbl_Students` ";
            JRDesignQuery jq=new JRDesignQuery();
            jq.setText(sq);
            jd.setQuery(jq);//
            JasperReport jas=JasperCompileManager.compileReport(jd);
            JasperPrint jprn=JasperFillManager.fillReport(jas, null, Conn);
            JasperViewer.viewReport(jprn,Boolean.FALSE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nJasper Error");
        }
    }//GEN-LAST:event_PrVwStdActionPerformed

    private void JrXmGen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JrXmGen1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JrXmGen1ActionPerformed

    private void VwCred1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VwCred1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VwCred1ActionPerformed

    private void SyncRepo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SyncRepo1ActionPerformed
        // TODO add your handling code here:
        String et,fll,trm;
        Calendar cl=new GregorianCalendar();
        int Y=cl.get(Calendar.YEAR);
        et=RepoEX1.getSelectedItem().toString();
        fll=RepoClas1.getSelectedItem().toString();
        Nm();
        Tbll=lst;
        String pc=null;

        if (RepoClas1.getSelectedIndex()==0) {
            pc="Form3";
        }
        if (RepoClas1.getSelectedIndex()==1) {
            pc="Form4";
        }
        
        if (RepoEX1.getSelectedIndex()==0) {
            Tem="CATS";
        }
        if (RepoEX1.getSelectedIndex()==1) {
            Tem="Mid_Term";
        }
        if (RepoEX1.getSelectedIndex()==2) {
            Tem="End_Term";
        }
        
        if (RepoTrm1.isSelected()) {
            mck="Term 1";
        }else if (RepoTrm2.isSelected()) {
            mck="Term 2";
        }else if (RepoTrm3.isSelected()) {
            mck="Term 3";
        }
        String Sblist=SblistBox.getSelectedItem().toString();
        
            try {
                Makeit();
                String cops="SELECT Name,Reg_No,Stream,Mathematics,English,Kiswahili,"+Sblist+" FROM "+Tbll+" WHERE (`Class`='"+pc+"' )";
                pst=(PreparedStatement) Conn.prepareStatement(cops);
                rs=pst.executeQuery();
                RepoTbl1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nAlevel 012");
            }
    }//GEN-LAST:event_SyncRepo1ActionPerformed

    private void Mprnt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mprnt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Mprnt1ActionPerformed

    private void WannaBeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WannaBeActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tts=(DefaultTableModel) RepoTbl.getModel();
        int reg=Integer.parseInt(RepoTbl.getValueAt(RepoTbl.getSelectedRow(), 1).toString()) ;
        String stfnam=(RepoTbl.getValueAt(RepoTbl.getSelectedRow(), 0).toString()) ;
        try {
            String locc="/media/niccher/Bookies/Ap/Coding Theory/3/Muruaky3.0/src/v3/Wannabe.jrxml";
            JasperDesign jd=JRXmlLoader.load(locc);
            //lst="Name,Class,Reg_No,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,History,CRE,Business,Agriculture";
            String sq="SELECT * FROM "+lst+" WHERE Reg_No="+reg+" ";
            JRDesignQuery nq=new JRDesignQuery();
            nq.setText(sq);
            jd.setQuery(nq);//
            JasperReport jas=JasperCompileManager.compileReport(jd);
            JasperPrint jprn=JasperFillManager.fillReport(jas, null, Conn);
            JasperViewer.viewReport(jprn,Boolean.FALSE);
            
            
            
            String jrpdf="/media/niccher/Bookies/Ap/Coding Theory/3/Muruaky3.0/"+stfnam+".pdf";
            JRExporter exp=new JRPdfExporter();
            exp.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, jrpdf);
            exp.setParameter(JRExporterParameter.JASPER_PRINT, jprn);
            exp.exportReport();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nJasper Error");
        }
    }//GEN-LAST:event_WannaBeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MiscT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiscT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiscT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiscT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiscT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ada;
    private javax.swing.JCheckBox AddF1;
    private javax.swing.JCheckBox AddF1E;
    private javax.swing.JCheckBox AddF1N;
    private javax.swing.JCheckBox AddF1S;
    private javax.swing.JCheckBox AddF1W;
    private javax.swing.JCheckBox AddF2;
    private javax.swing.JCheckBox AddF2E;
    private javax.swing.JCheckBox AddF2N;
    private javax.swing.JCheckBox AddF2S;
    private javax.swing.JCheckBox AddF2W;
    private javax.swing.JCheckBox AddF3;
    private javax.swing.JCheckBox AddF3E;
    private javax.swing.JCheckBox AddF3N;
    private javax.swing.JCheckBox AddF3S;
    private javax.swing.JCheckBox AddF3W;
    private javax.swing.JCheckBox AddF4;
    private javax.swing.JCheckBox AddF4E;
    private javax.swing.JCheckBox AddF4N;
    private javax.swing.JCheckBox AddF4S;
    private javax.swing.JCheckBox AddF4W;
    private javax.swing.JPanel AddMrk;
    private javax.swing.JPanel Admin;
    private javax.swing.JPanel Alll;
    private javax.swing.JButton BacSett;
    private javax.swing.JButton Bcer;
    private javax.swing.JComboBox<String> Canos2;
    private javax.swing.JCheckBox Cbf1;
    private javax.swing.JCheckBox Cbf2;
    private javax.swing.JCheckBox Cbf3;
    private javax.swing.JCheckBox Cbf4;
    private javax.swing.JCheckBox Cbf5;
    private javax.swing.JCheckBox Cbf6;
    private javax.swing.JCheckBox Cbf7;
    private javax.swing.JCheckBox Cbf8;
    private javax.swing.JPanel Centa;
    private javax.swing.JTable ClVwTY;
    private javax.swing.JComboBox<String> ClassCatFM1;
    private javax.swing.JComboBox<String> ClassCatPm1;
    private javax.swing.JComboBox<String> ClassEndFM1;
    private javax.swing.JComboBox<String> ClassEndPM1;
    private javax.swing.JComboBox<String> ClassLv;
    private javax.swing.JComboBox<String> ClassLvCat1;
    private javax.swing.JComboBox<String> ClassLvCatSbj1;
    private javax.swing.JComboBox<String> ClassLvEnd1;
    private javax.swing.JComboBox<String> ClassLvEndSbj1;
    private javax.swing.JComboBox<String> ClassLvMid1;
    private javax.swing.JComboBox<String> ClassLvMidSbj1;
    private javax.swing.JComboBox<String> ClassMidFM1;
    private javax.swing.JComboBox<String> ClassMidPM1;
    private javax.swing.JComboBox<String> ClassVw;
    private javax.swing.JComboBox<String> Classe;
    private javax.swing.JComboBox<String> Classe1;
    private javax.swing.JComboBox<String> Clser;
    private javax.swing.JComboBox<String> Clss;
    private javax.swing.JComboBox<String> ComBin;
    private javax.swing.JTextArea CommBox;
    private javax.swing.JPanel Conff;
    private javax.swing.JComboBox<String> ConnecView;
    private javax.swing.JTextField ConsBox;
    private javax.swing.JPanel Cpan;
    private javax.swing.JTextField CsvGt;
    private javax.swing.JRadioButton Cts;
    private javax.swing.JLabel DpImg;
    private javax.swing.JDesktopPane DpImgS;
    private javax.swing.JRadioButton Ets;
    private javax.swing.JComboBox<String> Ex1Perf;
    private javax.swing.JComboBox<String> Ex2Perf;
    private javax.swing.JComboBox<String> ExamBay;
    private javax.swing.JComboBox<String> ExamType;
    private javax.swing.JButton Ext;
    private javax.swing.JComboBox<String> ExxamTY;
    private javax.swing.JComboBox<String> ExxamTY1;
    private javax.swing.JLabel F1Log;
    private javax.swing.JLabel F2Log;
    private javax.swing.JLabel F3Log;
    private javax.swing.JLabel F4Log;
    private javax.swing.JButton FFCATS;
    private javax.swing.JButton FFEnd;
    private javax.swing.JButton FFMid;
    private javax.swing.JComboBox<String> FltBy;
    private javax.swing.JComboBox<String> FltPrf;
    private javax.swing.JTextField FmSch2;
    private javax.swing.JTextField Fnm2;
    private javax.swing.JComboBox<String> FormGrad;
    private javax.swing.JComboBox<String> FrmSenrAdd;
    private javax.swing.JPanel FrmVw;
    private javax.swing.JPanel Futa;
    private javax.swing.JTextField GCont;
    private javax.swing.JButton GenRepo;
    private javax.swing.JButton GenSvw;
    private javax.swing.JComboBox<String> GenTbl;
    private javax.swing.JButton GenTvw;
    private javax.swing.JTextField Gnm;
    private javax.swing.JTextArea GraBox;
    private javax.swing.JComboBox<String> GradIt;
    private javax.swing.JButton Graphyy;
    private javax.swing.JButton GrdSett;
    private javax.swing.JComboBox<String> Gres;
    private javax.swing.JPanel Hdd;
    private javax.swing.JPanel Heda;
    private javax.swing.JComboBox<String> Hrange;
    private javax.swing.JTextField ImgP;
    private javax.swing.JButton InsrtSenr;
    private javax.swing.JButton JrXmGen;
    private javax.swing.JButton JrXmGen1;
    private javax.swing.JComboBox<String> KcGrad2;
    private javax.swing.JTextField KcMrk2;
    private javax.swing.JTable Leva;
    private javax.swing.JComboBox<String> Lrange;
    private javax.swing.JPanel Mainn;
    private javax.swing.JPanel Mann;
    private javax.swing.JButton MnStdAdd;
    private javax.swing.JButton MnStdAdminy;
    private javax.swing.JButton MnStdRepo;
    private javax.swing.JButton MnStdeExams;
    private javax.swing.JButton Mprnt;
    private javax.swing.JButton Mprnt1;
    private javax.swing.JRadioButton Mts;
    private javax.swing.JRadioButton NWstdStAgr;
    private javax.swing.JRadioButton NWstdStBio;
    private javax.swing.JRadioButton NWstdStBus;
    private javax.swing.JRadioButton NWstdStCRE;
    private javax.swing.JRadioButton NWstdStChm;
    private javax.swing.JTextField NWstdStFm;
    private javax.swing.JRadioButton NWstdStGeo;
    private javax.swing.JRadioButton NWstdStHist;
    private javax.swing.JTextField NWstdStNm;
    private javax.swing.JRadioButton NWstdStPhy;
    private javax.swing.JTextField NWstdStRg;
    private javax.swing.JTable Niggatbl;
    private javax.swing.JPanel NwStd;
    private javax.swing.JComboBox<String> NwStdDrm;
    private javax.swing.JComboBox<String> NwStdDrmCbl;
    private javax.swing.JComboBox<String> NwStdFrm;
    private javax.swing.JComboBox<String> NwStdFrmSrm;
    private javax.swing.JButton NwStdImg;
    private javax.swing.JButton NwStdReg;
    private javax.swing.JButton NwStdSbj;
    private javax.swing.JButton NwStdUpd;
    private javax.swing.JButton Nxt;
    private javax.swing.JLabel OtCom;
    private javax.swing.JButton PFSorta;
    private javax.swing.JCheckBox PP1e;
    private javax.swing.JCheckBox PP1m;
    private javax.swing.JCheckBox PP2e;
    private javax.swing.JCheckBox PP2m;
    private javax.swing.JCheckBox PP3e;
    private javax.swing.JCheckBox PP3m;
    private javax.swing.JComboBox<String> PasFail;
    private javax.swing.JPanel Pg0;
    private javax.swing.JButton PrVwStd;
    private javax.swing.JButton PrntRepo;
    private javax.swing.JButton RegAsBtn;
    private javax.swing.JPanel Repo;
    private javax.swing.JComboBox<String> RepoClas;
    private javax.swing.JComboBox<String> RepoClas1;
    private javax.swing.JComboBox<String> RepoEX;
    private javax.swing.JComboBox<String> RepoEX1;
    private javax.swing.JTable RepoTbl;
    private javax.swing.JTable RepoTbl1;
    private javax.swing.JRadioButton RepoTrm1;
    private javax.swing.JRadioButton RepoTrm2;
    private javax.swing.JRadioButton RepoTrm3;
    private javax.swing.JRadioButton RepoTrm4;
    private javax.swing.JRadioButton RepoTrm5;
    private javax.swing.JRadioButton RepoTrm6;
    private javax.swing.JTextField RgNo;
    private javax.swing.JButton Rsh;
    private javax.swing.JButton RstCont;
    private javax.swing.JButton SCls;
    private javax.swing.JComboBox<String> SOmo;
    private javax.swing.JComboBox<String> SbjBox;
    private javax.swing.JComboBox<String> SbjSenrChus;
    private javax.swing.JComboBox<String> SblistBox;
    private javax.swing.JPanel Senr;
    private javax.swing.JTable SenrConfTbl;
    private javax.swing.JButton SetCont;
    private javax.swing.JPanel Sett;
    private javax.swing.JLabel SlCont;
    private javax.swing.JButton SncSenr;
    private javax.swing.JTextField Snm2;
    private javax.swing.JTable SnrTblAd;
    private javax.swing.JInternalFrame SpacAllc;
    private javax.swing.JComboBox<String> SrchConst;
    private javax.swing.JTable SrtRes;
    private javax.swing.JComboBox<String> StrNxt;
    private javax.swing.JComboBox<String> StrPerf;
    private javax.swing.JComboBox<String> StrmSenrAdd;
    private javax.swing.JComboBox<String> SubGrad;
    private javax.swing.JPanel Svw;
    private javax.swing.JRadioButton SvwRad;
    private javax.swing.JButton SyncRepo;
    private javax.swing.JButton SyncRepo1;
    private javax.swing.JComboBox<String> Terma;
    private javax.swing.JRadioButton Tr1;
    private javax.swing.JRadioButton Tr2;
    private javax.swing.JRadioButton Tr3;
    private javax.swing.JRadioButton Tr4;
    private javax.swing.JRadioButton Tr5;
    private javax.swing.JRadioButton Tr6;
    private javax.swing.JRadioButton Trm1;
    private javax.swing.JRadioButton Trm2;
    private javax.swing.JRadioButton Trm3;
    private javax.swing.JButton TrnCls;
    private javax.swing.JTable Tsta;
    private javax.swing.JPanel Tvw;
    private javax.swing.JComboBox<String> TvwLst;
    private javax.swing.JRadioButton TvwRad;
    private javax.swing.JButton VwCred;
    private javax.swing.JButton VwCred1;
    private javax.swing.JButton WannaBe;
    private javax.swing.JButton Wrt;
    private javax.swing.JComboBox<String> YBx;
    private javax.swing.JComboBox<String> YBx1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JTextField eXA;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JLabel nott;
    private javax.swing.JComboBox<String> uPtBL;
    // End of variables declaration//GEN-END:variables
}
