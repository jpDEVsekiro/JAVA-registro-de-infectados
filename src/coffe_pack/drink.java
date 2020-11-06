package coffe_pack;

import con_pack.ConnectionFactory;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.rmi.UnexpectedException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.text.JTextComponent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class drink implements ActionListener {
    ImageIcon back = new ImageIcon(getClass().getResource("icone_voltar.png"));
    ImageIcon pesquisar = new ImageIcon(getClass().getResource("procurar.png"));
    ImageIcon backiconbd = new ImageIcon(getClass().getResource("seta-esquerda.png"));
    ImageIcon nexticonbd = new ImageIcon(getClass().getResource("seta-direita.png"));
    ImageIcon pesquisa = new ImageIcon(getClass().getResource("pesquisa.png"));
    ImageIcon virusbg = new ImageIcon(getClass().getResource("virus.jpg"));
    ImageIcon seringa = new ImageIcon(getClass().getResource("sering.png"));
    ImageIcon virus = new ImageIcon(getClass().getResource("multidao.png"));
    ImageIcon cranio = new ImageIcon(getClass().getResource("bacteria.png"));
    ImageIcon craniov = new ImageIcon(getClass().getResource("amostra.png"));
    ImageIcon sair = new ImageIcon(getClass().getResource("virus.png"));
    Connection con;
    JFrame f;
    JPanel p, a, b, c, d, login;
    ChartPanel doencas1;
    ChartPanel doencas2;
    ChartPanel doencas3;
    ChartPanel doencas4;
    ChartPanel doencas5;
    JScrollPane barroll, doabarroll, doabarollpesquisa, doabarrolledit;
    String value, pesqbd, countpesbd, casobd = "0", cidadenome, vito, casoconfir, and;
    int i = 1, sd = 0, txe1 = 0, txe2 = 0, txe3 = 0, txe4 = 0, txe5 = 0, txe6 = 0, txe7 = 0, txe8 = 0, asd = 0, asddf = 0, dasfsd = 1, countbd, pesqok = 0, dasfsdmax, nro[], nro1 = 1, txe9 = 0, txe11 = 0, txe10 = 0, txe10b = 1, txe12 = 0, txe13 = 0, idade, caso, tela, diah, mesh, anoh, totalcasos[][];
    Color cor, cor2, cor3;
    JSpinner spinner_Idade = new JSpinner(new SpinnerNumberModel(1, 0, null, 1));
    JLabel viru = new JLabel(virusbg);
    JLabel usuariosbd = new JLabel();
    JLabel bordas = new JLabel();
    JLabel Jbaroll = new JLabel();
    JLabel iconnext = new JLabel();
    JLabel pagbd = new JLabel();
    JLabel pesquisa_tamanho = new JLabel("<html> <div height=550px width=10px></div>");
    JLabel tipo_sanguineo = new JLabel("<html><font size=5 color=rgb(0,0,0)>tipo sanguineo:<html>");
    JLabel logintx = new JLabel("<html><font size=5 color=rgb(0,0,0)>login:<html>");
    JLabel senhatx = new JLabel("<html><font size=5 color=rgb(0,0,0)>senha:<html>");
    JLabel estado = new JLabel("<html><font size=5 color=rgb(0,0,0)>estado:<html>");
    JLabel CEP = new JLabel("<html><font size=5 color=rgb(0,0,0)>CEP:<html>");
    JLabel telefone = new JLabel("<html><font size=5 color=rgb(0,0,0)>telefone:<html>");
    JLabel fixo = new JLabel("<html><font size=5 color=rgb(0,0,0)>(fixo):<html>");
    JLabel movel = new JLabel("<html><font size=5 color=rgb(0,0,0)>(móvel):<html>");
    JLabel RG = new JLabel("<html><font size=5 color=rgb(0,0,0)>RG:<html>");
    JLabel RUA = new JLabel("<html><font size=5 color=rgb(0,0,0)>RUA:<html>");
    JLabel BAIRRO = new JLabel("<html><font size=5 color=rgb(0,0,0)>bairro:<html>");
    JLabel NUMERO = new JLabel("<html><font size=5 color=rgb(0,0,0)>número da residencia:<html>");
    JLabel NUMERO_caso = new JLabel("<html><font size=5 color=rgb(0,0,0)>caso nùmero:<html>");
    JLabel email = new JLabel("<html><font size=5 color=rgb(0,0,0)>email:<html>");
    JLabel telefonefixo = new JLabel("<html><font size=5 color=rgb(0,0,0)>telefone(fixo):<html>");
    JLabel telefonemovel = new JLabel("<html><font size=5 color=rgb(0,0,0)>telefone(móvel):<html>");
    JLabel proxima_pagina = new JLabel("<html><font size=5 color=rgb(0,0,0)>  próxima página<html>");
    JLabel pagina_anterior = new JLabel("<html><font size=5 color=rgb(0,0,0)> página anterior<html>");
    JLabel tipo_cidade = new JLabel("<html><font size=5 color=rgb(0,0,0)>cidade:<html>");
    JLabel text = new JLabel("<html><div height=1900px width=10px><html>");
    JLabel textb1 = new JLabel("<html><font size=4 color=rgb(0,0,0)> &nbsp   &nbsp  &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  dados &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp   estátisticos<html>");
    JLabel cadastro = new JLabel("<html><font size=5 color=rgb(0,0,0)>       &nbsp &nbsp &nbsp  cadastrar<html>");
    JLabel textb2 = new JLabel("<html><font size=4 color=rgb(0,0,0)>  &nbsp  &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp editar cadastros<html>");
    JLabel textb3 = new JLabel("<html><font size=4 color=rgb(0,0,0)>  &nbsp  &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp banco de dados   &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  dos infectados<html>");
    JLabel textb4 = new JLabel("<html><font size=4 color=rgb(0,0,0)>  &nbsp  &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp adicionar &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp infectado<html>");
    JLabel textb5 = new JLabel("<html><b><font size=4 color=rgb(0,0,0)>  &nbsp  &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp sair<html>");
    JLabel texterro = new JLabel("<html><font size=5 color=rgb(255,0,0)> nome inválido<html>");
    JLabel texterro2 = new JLabel("<html><font size=5 color=rgb(255,0,0)> CEP invalida <html>");
    JLabel texterro3 = new JLabel("<html><font size=5 color=rgb(255,0,0)> data inválida <html>");
    JLabel texterro4 = new JLabel("<html><font size=5 color=rgb(255,0,0)> CPF ou RG inválido <html>");
    JLabel texterro5 = new JLabel("<html><font size=5 color=rgb(255,0,0)> peso ou altura inválido<html>");
    JLabel texterro6 = new JLabel("<html><font size=5 color=rgb(255,0,0)> nome inválido <html>");
    JLabel texterro7 = new JLabel("<html><font size=5 color=rgb(255,0,0)> nome inválido <html>");
    JLabel texterro8 = new JLabel("<html><font size=5 color=rgb(255,0,0)> selecione uma cidade <html>");
    JLabel texterro9 = new JLabel("<html><font size=5 color=rgb(255,0,0)> email inválido<html>");
    JLabel texterro10 = new JLabel("<html><font size=5 color=rgb(255,0,0)> prencha o campo <html>");
    JLabel texterro11 = new JLabel("<html><font size=5 color=rgb(255,0,0)> estado inválido <html>");
    JLabel texterro12 = new JLabel("<html><font size=5 color=rgb(255,0,0)>rua inválido <html>");
    JLabel texterro13 = new JLabel("<html><font size=5 color=rgb(255,0,0)> bairro inválido <html>");
    JLabel textnome = new JLabel("<html><font size=5 color=rgb(0,0,0)> nome: <html>");
    JLabel cadastrob = new JLabel("<html><font size=5 color=rgb(0,0,0)> <html>");
    JLabel textidade = new JLabel("<html><font size=5 color=rgb(0,0,0)> idade: <html>");
    JLabel textvito = new JLabel("<html><font size=5 color=rgb(0,0,0)> estado de vida: <html>");
    JLabel textdatadenascimento = new JLabel("<html><font size=5 color=rgb(0,0,0)>data de nascimento: <html>");
    JLabel textcpf = new JLabel("<html><font size=5 color=rgb(0,0,0)>CPF: <html>");
    JLabel textpeso_altura = new JLabel("<html><font size=5 color=rgb(0,0,0)>peso e altura: <html>");
    JLabel textpeso = new JLabel("<html><font size=5 color=rgb(0,0,0)>peso: <html>");
    JLabel textaltura = new JLabel("<html><font size=5 color=rgb(0,0,0)>altura: <html>");
    JLabel textmae = new JLabel("<html><font size=5 color=rgb(0,0,0)>nome da mãe:<html>");
    JLabel textpai = new JLabel("<html><font size=5 color=rgb(0,0,0)>nome do pai:<html>");
    JLabel textcidade = new JLabel("<html><font size=5 color=rgb(0,0,0)>cidade:<html>");
    JLabel text_sangue = new JLabel("<html><font size=5 color=rgb(0,0,0)>tipo sanguineo: <html>");
    JLabel erlogin = new JLabel("<html><font size=6 color=rgb(255,0,0)>login incorreto <html>");
    JLabel ersenha = new JLabel("<html><font size=6 color=rgb(255,0,0)>senha incorreta <html>");
    JLabel adicionar_infectado = new JLabel("<html><font size=6 color=rgb(0,0,0)> &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp  Adicionar Infectado <html>");
    JLabel adicionar_sobre_virus = new JLabel("<html><font size=6 color=rgb(0,0,0)> &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp dados Estatísticos <html>");
    JLabel adicionar_login = new JLabel("<html><font size=6 color=rgb(0,0,0)> &nbsp   &nbsp   &nbsp   &nbsp &nbsp   &nbsp &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp login <html>");
    JLabel adicionar_vacina = new JLabel("<html><font size=6 color=rgb(0,0,0)> &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp Sobre a vacina<html>");
    JLabel adicionar_bd = new JLabel();
    JLabel excluir_editar = new JLabel();
    JButton jbpesquisa = new JButton("PESQUISAR", pesquisa);
    JButton jb1 = new JButton("                                        ", cranio);
    JButton jb2 = new JButton("                                        ", seringa);
    JButton jb3 = new JButton("                                        ", virus);
    JButton jb4 = new JButton("                                        ", craniov);
    JButton jb5 = new JButton("                                        ", sair);
    JButton jb6 = new JButton(null, back);
    JButton jb7 = new JButton(null, back);
    JButton jb8 = new JButton(null, back);
    JButton jb9 = new JButton(null, back);
    JButton jb10 = new JButton(null, back);
    JButton cadastrar = new JButton("                                        ", null);
    JButton entrar = new JButton("ENTRAR", null);
    JButton nextbd = new JButton(null, null);
    JButton backbd = new JButton("                                        ", null);
    JRadioButton rdbtn_Cidade_1 = new JRadioButton("são paulo");
    JRadioButton rdbtn_Cidade_2 = new JRadioButton("são bernado do campo");
    JRadioButton rdbtn_Cidade_3 = new JRadioButton("santo andré");
    JRadioButton rdbtn_Cidade_4 = new JRadioButton("são caetano");
    JRadioButton rdbtn_Cidade_5 = new JRadioButton("mauá");
    JSpinner spinnerDataDia = new JSpinner(new SpinnerNumberModel(0, 0, 31, 1));
    JSpinner spinnerDataMes = new JSpinner(new SpinnerNumberModel(0, 0, 12, 1));
    JSpinner spinnerDataAno = new JSpinner(new SpinnerNumberModel(0, 0, 2020, 1));
    JSpinner spinnernumero = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
    JSpinner spinnercaso = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
    JFormattedTextField textField_Nome;
    JTextField textField_pesquisa;
    JFormattedTextField emaildig;
    JFormattedTextField estadodig;
    JFormattedTextField ruadig;
    JFormattedTextField bairrodig;
    JFormattedTextField formattedTextField_login = new JFormattedTextField();
    JPasswordField formattedTextField_senha = new JPasswordField();
    JFormattedTextField formattedTextField_CPF = new JFormattedTextField();
    JFormattedTextField formattedTextField_RG = new JFormattedTextField();
    JFormattedTextField formattedTextField_CEP = new JFormattedTextField();
    JFormattedTextField formattedTextField_Altura = new JFormattedTextField();
    JFormattedTextField formattedTextField_Peso = new JFormattedTextField();
    JFormattedTextField formattedTextField_telfixo = new JFormattedTextField();
    JFormattedTextField formattedTextField_telmovel = new JFormattedTextField();
    JFormattedTextField textField_mae = new JFormattedTextField();
    JFormattedTextField textField_pai = new JFormattedTextField();
    MaskFormatter mask_CPF, mask_cep, mask_telfixo, mask_telmovel, mask_peso, mask_RG, mask_altura, name, namepai, namemae, namebairro, namerua, namecidade, nameestado, nameemail;
    PreparedStatement pesquisab;
    JComboBox<String> sangue = new JComboBox<>();
    JComboBox<String> estado_devida = new JComboBox<>();
    JComboBox<String> sangue_pesquisa = new JComboBox<>();
    JComboBox<String> cidade_box = new JComboBox<>();
    JComboBox<String> caso_conf = new JComboBox<>();
    JButton[] botoesN;
    JButton btn_pesquisar;
    JLabel edit = new JLabel("<html> <div height=350px width=10px></div>");
    JTextField txt_Codigo_cadastro;
    JComboBox comboBox_cidade = new JComboBox();
    JTextField txt_nome;
    JSpinner spinner_Idaded = new JSpinner();
    JSpinner spinner_Nascimento_Dia = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
    JSpinner spinner_Nacimento_Mes = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
    JSpinner spinner_Nascimento_Ano = new JSpinner(new SpinnerNumberModel(2000, 1800, 2020, 1));
    JFormattedTextField formatted_txt_cpf = new JFormattedTextField();
    JFormattedTextField formatted_txt_rg = new JFormattedTextField();
    JFormattedTextField txt_peso = new JFormattedTextField();
    MaskFormatter mask_PESO, num;
    JFormattedTextField txt_altura = new JFormattedTextField();
    JComboBox comboBox_tipo_sanguineo = new JComboBox();
    JFormattedTextField text_Nome_pai;
    JFormattedTextField txt_nome_mae;
    JFormattedTextField txt_rua;
    JFormattedTextField txt_cep;
    JFormattedTextField txt_numero;
    JFormattedTextField txt_bairro;
    JFormattedTextField txt_cidade;
    JComboBox comboBox_estado = new JComboBox();
    JFormattedTextField txt_telefone_fixo = new JFormattedTextField();
    JFormattedTextField txt_telefone_movel = new JFormattedTextField();
    JFormattedTextField txt_email;
    JButton btn_aplicar = new JButton();
    JButton btn_excluir = new JButton();
    static ConnectionFactory conexao = new ConnectionFactory();

    public drink() {
        f = new JFrame("H1N1 V1.3.0");
        f.setSize(1050, 539);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        janela();
    }

    private void janela() {
        if (i == 1) {
            p = new JPanel();
            f.add(p);
            p.setLayout(null);
            p.add(viru);
            viru.setBounds(200, 0, 845, 511);
            viru.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 3, true));
            cor = new Color(147, 112, 219);
            cor2 = new Color(138, 43, 226);
            cor3 = new Color(60, 179, 113);
            jb1.setBounds(0, 0, 200, 102);
            p.add(jb1);
            jb1.add(textb1);
            this.jb1.setBackground(cor);
            jb1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 1, true));
            jb1.addActionListener(this);
            jb2.setBounds(0, 102, 200, 102);
            p.add(jb2);
            this.jb2.setBackground(cor);
            jb2.addActionListener(this);
            jb2.add(textb2);
            jb2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 1, true));
            jb3.setBounds(0, 204, 200, 102);
            p.add(jb3);
            this.jb3.setBackground(cor);
            jb3.addActionListener(this);
            jb3.add(textb3);
            jb4.setBounds(0, 306, 200, 102);
            jb3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 1, true));
            p.add(jb4);
            this.jb4.setBackground(cor);
            jb4.addActionListener(this);
            jb4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 1, true));
            jb4.add(textb4);
            jb5.setBounds(0, 408, 200, 102);
            this.jb5.setBackground(cor);
            p.add(jb5);
            jb5.addActionListener(this);
            jb5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 1, true));
            jb5.add(textb5);
            a = new JPanel();
            b = new JPanel();
            c = new JPanel();
            d = new JPanel();
            login = new JPanel();
            i++;
        }
        a.setVisible(false);
        login.setVisible(false);
        b.setVisible(false);
        c.setVisible(false);
        d.setVisible(false);
        p.setVisible(true);
    }

    public void login() {
        f.add(login);
        login.setVisible(true);
        d.setVisible(false);
        b.setVisible(false);
        a.setVisible(false);
        p.setVisible(false);
        c.setVisible(false);
        login.setLayout(null);
        jb10.setBounds(0, 0, 60, 45);
        jb10.addActionListener(this);
        this.jb10.setBackground(cor);
        jb10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
        login.add(jb10);
        login.add(adicionar_login);
        adicionar_login.setBounds(60, 0, 985, 45);
        adicionar_login.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
        adicionar_login.setOpaque(true);
        adicionar_login.setBackground(cor);
        login.add(formattedTextField_login);
        login.add(formattedTextField_senha);
        login.add(ersenha);
        login.add(erlogin);
        login.add(entrar);
        formattedTextField_login.setBounds(400, 230, 220, 25);
        erlogin.setBounds(400, 130, 200, 50);
        erlogin.setVisible(false);
        formattedTextField_login.setText("");
        formattedTextField_senha.setText("");
        login.add(logintx);
        login.add(senhatx);
        logintx.setBounds(340, 215, 50, 50);
        formattedTextField_senha.setBounds(400, 290, 220, 25);
        ersenha.setBounds(400, 170, 220, 50);
        ersenha.setVisible(false);
        senhatx.setBounds(330, 275, 60, 50);
        entrar.setBounds(450, 350, 100, 40);
        entrar.addActionListener(this);
        login.add(bordas);
        bordas.setBounds(307, 80, 360, 350);
        bordas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        formattedTextField_senha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        formattedTextField_login.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
    }

    public void janela2() {
        f.add(a);
        a.setVisible(true);
        login.setVisible(false);
        b.setVisible(false);
        p.setVisible(false);
        c.setVisible(false);
        d.setVisible(false);
        a.setLayout(null);
        jb6.setBounds(0, 0, 60, 45);
        jb6.addActionListener(this);
        this.jb6.setBackground(cor);
        jb6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
        a.add(jb6);
        a.add(adicionar_sobre_virus);
        adicionar_sobre_virus.setBounds(60, 0, 985, 45);
        adicionar_sobre_virus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
        adicionar_sobre_virus.setOpaque(true);
        adicionar_sobre_virus.setBackground(cor);
        barroll = new JScrollPane(text);
        text.setBounds(0, 0, 1050, 539);
        barroll.setBorder(null);
        barroll.setBounds(0, 45, 1045, 467);
        a.add(barroll);
        barroll.getVerticalScrollBar().setUnitIncrement(15);
        try {
            totalcasos = new int[2021][6];
            for (int i = 2001; i <= 2020; i++) {
                Connection con = new con_pack.ConnectionFactory().getConnection();
                PreparedStatement pesquisa = con.prepareStatement(" SELECT YEAR(DATA_REG) as ano,FK_CASO_ESTADO FROM CASO INNER JOIN ENDERECO ON CASO.COD_CASO=FK_ENDERECO_CASO WHERE YEAR(DATA_REG)=" + i + " ;");
                ResultSet conta = pesquisa.executeQuery();
                while (conta.next()) {
                    String cidadebd = conta.getString("FK_CASO_ESTADO");
                    switch (cidadebd) {
                        case "11"://SBC
                            totalcasos[i][1] = totalcasos[i][1] + 1;
                            totalcasos[1][1] = totalcasos[1][1] + 1;
                            break;
                        case "33"://santo andre
                            totalcasos[i][2] = totalcasos[i][2] + 1;
                            totalcasos[1][2] = totalcasos[1][2] + 1;
                            break;
                        case "55"://maua
                            totalcasos[i][3] = totalcasos[i][3] + 1;
                            totalcasos[1][3] = totalcasos[1][3] + 1;
                            break;
                        case "44"://SP
                            totalcasos[i][4] = totalcasos[i][4] + 1;
                            totalcasos[1][4] = totalcasos[1][4] + 1;

                            break;
                        case "22"://são caetano
                            totalcasos[i][5] = totalcasos[i][5] + 1;
                            totalcasos[1][5] = totalcasos[1][5] + 1;
                            break;
                    }

                }
            }
        } catch (SQLException | ClassNotFoundException | UnexpectedException ex) {
            Logger.getLogger(drink.class.getName()).log(Level.SEVERE, null, ex);
        }

        XYSeries series1 = new XYSeries("são bernado do campo");
        XYSeries series2 = new XYSeries("santo andré");
        XYSeries series3 = new XYSeries("mauá");
        XYSeries series4 = new XYSeries("são paulo");
        XYSeries series5 = new XYSeries("são caetano");
        series1.add(2001, totalcasos[2001][1]);
        series1.add(2002, totalcasos[2002][1]);
        series1.add(2003, totalcasos[2003][1]);
        series1.add(2004, totalcasos[2004][1]);
        series1.add(2005, totalcasos[2005][1]);
        series1.add(2006, totalcasos[2006][1]);
        series1.add(2007, totalcasos[2007][1]);
        series1.add(2008, totalcasos[2008][1]);
        series1.add(2009, totalcasos[2009][1]);
        series1.add(2010, totalcasos[2010][1]);
        series1.add(2011, totalcasos[2011][1]);
        series1.add(2012, totalcasos[2012][1]);
        series1.add(2013, totalcasos[2013][1]);
        series1.add(2014, totalcasos[2014][1]);
        series1.add(2015, totalcasos[2015][1]);
        series1.add(2016, totalcasos[2016][1]);
        series1.add(2017, totalcasos[2017][1]);
        series1.add(2018, totalcasos[2018][1]);
        series1.add(2019, totalcasos[2019][1]);
        series1.add(2020, totalcasos[2020][1]);
        series2.add(2001, totalcasos[2001][2]);
        series2.add(2002, totalcasos[2002][2]);
        series2.add(2003, totalcasos[2003][2]);
        series2.add(2004, totalcasos[2004][2]);
        series2.add(2005, totalcasos[2005][2]);
        series2.add(2006, totalcasos[2006][2]);
        series2.add(2007, totalcasos[2007][2]);
        series2.add(2008, totalcasos[2008][2]);
        series2.add(2009, totalcasos[2009][2]);
        series2.add(2010, totalcasos[2010][2]);
        series2.add(2011, totalcasos[2011][2]);
        series2.add(2012, totalcasos[2012][2]);
        series2.add(2013, totalcasos[2013][2]);
        series2.add(2014, totalcasos[2014][2]);
        series2.add(2015, totalcasos[2015][2]);
        series2.add(2016, totalcasos[2016][2]);
        series2.add(2017, totalcasos[2017][2]);
        series2.add(2018, totalcasos[2018][2]);
        series2.add(2019, totalcasos[2019][2]);
        series2.add(2020, totalcasos[2020][2]);
        series3.add(2001, totalcasos[2001][3]);
        series3.add(2002, totalcasos[2002][3]);
        series3.add(2003, totalcasos[2003][3]);
        series3.add(2004, totalcasos[2004][3]);
        series3.add(2005, totalcasos[2005][3]);
        series3.add(2006, totalcasos[2006][3]);
        series3.add(2007, totalcasos[2007][3]);
        series3.add(2008, totalcasos[2008][3]);
        series3.add(2009, totalcasos[2009][3]);
        series3.add(2010, totalcasos[2010][3]);
        series3.add(2011, totalcasos[2011][3]);
        series3.add(2012, totalcasos[2012][3]);
        series3.add(2013, totalcasos[2013][3]);
        series3.add(2014, totalcasos[2014][3]);
        series3.add(2015, totalcasos[2015][3]);
        series3.add(2016, totalcasos[2016][3]);
        series3.add(2017, totalcasos[2017][3]);
        series3.add(2018, totalcasos[2018][3]);
        series3.add(2019, totalcasos[2019][3]);
        series3.add(2020, totalcasos[2020][3]);
        series4.add(2001, totalcasos[2001][4]);
        series4.add(2002, totalcasos[2002][4]);
        series4.add(2003, totalcasos[2003][4]);
        series4.add(2004, totalcasos[2004][4]);
        series4.add(2005, totalcasos[2005][4]);
        series4.add(2006, totalcasos[2006][4]);
        series4.add(2007, totalcasos[2007][4]);
        series4.add(2008, totalcasos[2008][4]);
        series4.add(2009, totalcasos[2009][4]);
        series4.add(2010, totalcasos[2010][4]);
        series4.add(2011, totalcasos[2011][4]);
        series4.add(2012, totalcasos[2012][4]);
        series4.add(2013, totalcasos[2013][4]);
        series4.add(2014, totalcasos[2014][4]);
        series4.add(2015, totalcasos[2015][4]);
        series4.add(2016, totalcasos[2016][4]);
        series4.add(2017, totalcasos[2017][4]);
        series4.add(2018, totalcasos[2018][4]);
        series4.add(2019, totalcasos[2019][4]);
        series4.add(2020, totalcasos[2020][4]);
        series5.add(2001, totalcasos[2001][5]);
        series5.add(2002, totalcasos[2002][5]);
        series5.add(2003, totalcasos[2003][5]);
        series5.add(2004, totalcasos[2004][5]);
        series5.add(2005, totalcasos[2005][5]);
        series5.add(2006, totalcasos[2006][5]);
        series5.add(2007, totalcasos[2007][5]);
        series5.add(2008, totalcasos[2008][5]);
        series5.add(2009, totalcasos[2009][5]);
        series5.add(2010, totalcasos[2010][5]);
        series5.add(2011, totalcasos[2011][5]);
        series5.add(2012, totalcasos[2012][5]);
        series5.add(2013, totalcasos[2013][5]);
        series5.add(2014, totalcasos[2014][5]);
        series5.add(2015, totalcasos[2015][5]);
        series5.add(2016, totalcasos[2016][5]);
        series5.add(2017, totalcasos[2017][5]);
        series5.add(2018, totalcasos[2018][5]);
        series5.add(2019, totalcasos[2019][5]);
        series5.add(2020, totalcasos[2020][5]);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        dataset.addSeries(series4);
        dataset.addSeries(series5);
        JFreeChart graphl = ChartFactory.createXYLineChart("comparação das cidades", "ano", "infectados", dataset, PlotOrientation.VERTICAL, true, true, false);
        graphl.setBackgroundPaint(Color.white);
        XYPlot plot = graphl.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(1, true);
        renderer.setSeriesShapesVisible(1, true);
        renderer.setSeriesShapesVisible(1, true);
        renderer.setSeriesShapesVisible(1, true);
        renderer.setSeriesShapesVisible(1, true);
        plot.setRenderer(renderer);
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        doencas1 = new ChartPanel(graphl);
        text.add(doencas1);
        doencas1.setBounds(0, 0, 950, 450);
        graph();
    }

    public void janela3() {
        f.add(b);
        b.setVisible(true);
        p.setVisible(false);
        a.setVisible(false);
        c.setVisible(false);
        d.setVisible(false);
        login.setVisible(false);
        b.setLayout(null);
        jb7.setBounds(0, 0, 60, 45);
        jb7.addActionListener(this);
        this.jb7.setBackground(cor);
        jb7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
        b.add(jb7);
        b.add(adicionar_vacina);
        adicionar_vacina.setBounds(60, 0, 985, 45);
        adicionar_vacina.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
        adicionar_vacina.setOpaque(true);
        adicionar_vacina.setBackground(cor);
        b.add(excluir_editar);
        excluir_editar.setBounds(150, 461, 745, 50);
        excluir_editar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
        excluir_editar.setOpaque(true);
        excluir_editar.setBackground(cor);
        //    -----------------------------------------------------------------//
///////---------------------------------------------------------------------------------------------- CODIGO PARA PESQUISA
        doabarrolledit = new JScrollPane(edit);
        b.add(doabarrolledit);
        doabarrolledit.getVerticalScrollBar().setUnitIncrement(15);
        doabarrolledit.setBorder(null);
        doabarrolledit.setBounds(0, 45, 1045, 416);
        JLabel lbl_Codigo_Do_Cadastro = new JLabel("CODIGO DO CADASTRO:");
        lbl_Codigo_Do_Cadastro.setBounds(7, 11, 135, 14);
        edit.add(lbl_Codigo_Do_Cadastro);
        txt_Codigo_cadastro = new JTextField();
        txt_Codigo_cadastro.setHorizontalAlignment(SwingConstants.CENTER);
        txt_Codigo_cadastro.setToolTipText("");
        txt_Codigo_cadastro.setBounds(152, 8, 106, 20);
        edit.add(txt_Codigo_cadastro);
        txt_Codigo_cadastro.setColumns(10);

///////---------------------------------------------------------------------------------------------- BOTAO PESQUISAR
        btn_pesquisar = new JButton("PESQUISAR");
        btn_pesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                //EXECUTA O METODO BUSCAR_DADOS E 2 PLANO A CONSULTA
                new Thread() {
                    public void run() {
                        try {
                            excluir_editar.setText("<html><font size=5 color=rgb(0,0,0)> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp      &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp CARREGANDO...<html>");
                            buscar_Dados(Integer.parseInt(txt_Codigo_cadastro.getText()));
                            btn_aplicar.setEnabled(true);
                            btn_excluir.setEnabled(true);
                            txt_nome.setVisible(true);
                            excluir_editar.setText("");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "CODIGO DE CADASTRO INVALIDO OU INIXISTENTE");
                        }
                    }
                }.start();

            }
        });
        btn_pesquisar.setBounds(266, 8, 150, 22);
        edit.add(btn_pesquisar);

///////---------------------------------------------------------------------------------------------- CIDADE DE CADASTRO DO CASO
///////----------- LABEL CIDADE CIDADE DE CADASTRO DO CASO
        JLabel lbn_cidade_registro = new JLabel("CIDADE:");
        lbn_cidade_registro.setBounds(7, 57, 46, 14);
        edit.add(lbn_cidade_registro);

///////----------- AREA DE TEXTO CIDADE DE CADASTRO DO CASO
        comboBox_cidade.setModel(new DefaultComboBoxModel(new String[]{"cidade 1", "cidade 2", "cidade 3", "cidade 4", "cidade 5"}));
        comboBox_cidade.setBounds(57, 54, 97, 20);
        edit.add(comboBox_cidade);

///////---------------------------------------------------------------------------------------------- NOME
///////----------- LABEL NOME
        JLabel lbn_Nome = new JLabel("NOME:");
        lbn_Nome.setBounds(7, 87, 46, 14);
        edit.add(lbn_Nome);
///////----------- AREA DE TEXTO NOME
        txt_nome = new JFormattedTextField();
        //txt_nome.setVisible(false);
        txt_nome.setBounds(55, 84, 213, 20);
        edit.add(txt_nome);
        txt_nome.setColumns(10);
        try {
            name = new MaskFormatter("******************************");
            name.setValidCharacters("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZÁáÂâÀ àÃãÊêÈèÉéÍíÎîÌìÓóÔôÒòÚúÛûÙùÝý");
            name.install((JFormattedTextField) txt_nome);
        } catch (ParseException e) {
        }
        txt_nome.addFocusListener(new CaretPosition());

///////---------------------------------------------------------------------------------------------- IDADE
        JLabel lbl_Idade = new JLabel("IDADE:");
        lbl_Idade.setBounds(7, 117, 38, 14);
        edit.add(lbl_Idade);

        spinner_Idaded.setModel(new SpinnerNumberModel(0, 0, 100, 1));
        spinner_Idaded.setBounds(55, 114, 40, 20);
        edit.add(spinner_Idaded);
        //spinner_Idade.setValue(9999);

///////---------------------------------------------------------------------------------------------- DATA DE NASCIMENTO
        JLabel lbn_Data_de_nascimento = new JLabel("NASCIMENTO:");
        lbn_Data_de_nascimento.setBounds(7, 147, 82, 14);
        edit.add(lbn_Data_de_nascimento);

///////----------- DIA
        spinner_Nascimento_Dia.setBounds(90, 144, 40, 20);
        edit.add(spinner_Nascimento_Dia);

///////----------- MES
        spinner_Nacimento_Mes.setToolTipText("MES");
        spinner_Nacimento_Mes.setBounds(138, 144, 59, 20);
        edit.add(spinner_Nacimento_Mes);

///////----------- ANO
        spinner_Nascimento_Ano.setToolTipText("ANO");
        spinner_Nascimento_Ano.setBounds(207, 144, 59, 20);
        edit.add(spinner_Nascimento_Ano);

///////---------------------------------------------------------------------------------------------- CPF
///////----------- LABEL CPF
        JLabel lbn_CPF = new JLabel("CPF:");
        lbn_CPF.setBounds(7, 177, 50, 14);
        edit.add(lbn_CPF);
        formatted_txt_cpf.addFocusListener(new CaretPosition());

        try {
            ///////----------- AREA DE TEXTO CPF
            mask_CPF = new MaskFormatter("###.###.###-##");
        } catch (ParseException ex) {
            Logger.getLogger(drink.class.getName()).log(Level.SEVERE, null, ex);
        }
        mask_CPF.install(formatted_txt_cpf);
        formatted_txt_cpf.setBounds(38, 174, 82, 20);
        edit.add(formatted_txt_cpf);

///////---------------------------------------------------------------------------------------------- RG
///////----------- LABEL RG
        JLabel lbn_RG = new JLabel("RG:");
        lbn_RG.setBounds(128, 177, 24, 14);
        edit.add(lbn_RG);

///////----------- AREA DE TEXTO RG
        formatted_txt_rg.addFocusListener(new CaretPosition());
        formatted_txt_rg.setBounds(150, 174, 97, 20);
        edit.add(formatted_txt_rg);
        try {
            mask_RG = new MaskFormatter("##.###.###-#");
            mask_RG.install(formatted_txt_rg);
        } catch (ParseException ex) {
        }

///////---------------------------------------------------------------------------------------------- PESO
///////----------- LABEL RG
        JLabel lbn_Peso = new JLabel("PESO:");
        lbn_Peso.setBounds(7, 207, 40, 14);
        edit.add(lbn_Peso);

        try {
            ///////----------- AREA DE TEXTO
            mask_peso = new MaskFormatter("##.##");
        } catch (ParseException ex) {
        }
        mask_peso.install(txt_peso);
        txt_peso.setColumns(10);
        txt_peso.setBounds(47, 204, 31, 20);
        txt_peso.addFocusListener(new CaretPosition());
        edit.add(txt_peso);

///////---------------------------------------------------------------------------------------------- ALTURA
///////----------- LABEL ALTURA
        JLabel lbn_Altura = new JLabel("ALTURA:");
        lbn_Altura.setBounds(83, 207, 52, 14);
        edit.add(lbn_Altura);

        try {
            ///////----------- AREA DE TEXTO ALTURA
            mask_altura = new MaskFormatter("#.##");
        } catch (ParseException ex) {
            Logger.getLogger(drink.class.getName()).log(Level.SEVERE, null, ex);
        }
        mask_altura.install(txt_altura);
        txt_altura.addFocusListener(new CaretPosition());
        txt_altura.setColumns(10);
        txt_altura.setBounds(140, 204, 31, 20);
        edit.add(txt_altura);

///////---------------------------------------------------------------------------------------------- ALTURA
///////----------- LABEL TIPO SANGUINEO
        JLabel lbn_tipo_sanguineo = new JLabel("TIPO SANGUINEO:");
        lbn_tipo_sanguineo.setBounds(7, 237, 110, 14);
        edit.add(lbn_tipo_sanguineo);

///////----------- AREA DE TEXTO TIPO SANGUINEO
        comboBox_tipo_sanguineo.setModel(new DefaultComboBoxModel(new String[]{"A+", "B+", "AB+", "O+", "A-", "B-", "AB-", "O-"}));
        comboBox_tipo_sanguineo.setSelectedItem("B+");
        comboBox_tipo_sanguineo.setBounds(110, 234, 71, 20);
        edit.add(comboBox_tipo_sanguineo);

///////---------------------------------------------------------------------------------------------- NOME DO PAI
///////----------- LABEL NOME DO PAI
        JLabel lbn_Nome_pai = new JLabel("NOME PAI:");
        lbn_Nome_pai.setBounds(7, 267, 59, 14);
        edit.add(lbn_Nome_pai);

///////----------- AREA DE TEXTO NOME DO PAI
        text_Nome_pai = new JFormattedTextField();
        text_Nome_pai.setColumns(10);
        text_Nome_pai.setBounds(75, 264, 213, 20);
        edit.add(text_Nome_pai);
        text_Nome_pai.addFocusListener(new CaretPosition());
        try {
            namepai = new MaskFormatter("******************************");
            namepai.setValidCharacters("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZÁáÂâÀ àÃãÊêÈèÉéÍíÎîÌìÓóÔôÒòÚúÛûÙùÝý");
            namepai.install(text_Nome_pai);
        } catch (ParseException e) {
        }

///////---------------------------------------------------------------------------------------------- NOME DA MAE
///////----------- LABEL NOME DA MAE
        JLabel lbn_Nome_mae = new JLabel("NOME MAE:");
        lbn_Nome_mae.setBounds(7, 297, 75, 14);
        edit.add(lbn_Nome_mae);

///////----------- AREA DE TEXTO NOME DA MAE
        txt_nome_mae = new JFormattedTextField();
        txt_nome_mae.setColumns(10);
        txt_nome_mae.setBounds(75, 294, 213, 20);
        edit.add(txt_nome_mae);
        txt_nome_mae.addFocusListener(new CaretPosition());
        try {
            namemae = new MaskFormatter("******************************");
            namemae.setValidCharacters("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZÁáÂâÀ àÃãÊêÈèÉéÍíÎîÌìÓóÔôÒòÚúÛûÙùÝý");
            namemae.install(txt_nome_mae);
        } catch (ParseException e) {
        }

///////---------------------------------------------------------------------------------------------- RUA
///////----------- LABEL RUA
        JLabel lbn_rua = new JLabel("RUA:");
        lbn_rua.setBounds(740, 57, 46, 14);
        edit.add(lbn_rua);

///////----------- AREA DE TEXTO RUA
        txt_rua = new JFormattedTextField();
        txt_rua.setColumns(10);
        txt_rua.setBounds(795, 54, 213, 20);
        edit.add(txt_rua);
        txt_rua.addFocusListener(new CaretPosition());

        try {
            namerua = new MaskFormatter("******************************");
            namerua.install(txt_rua);
        } catch (ParseException e) {
        }

///////---------------------------------------------------------------------------------------------- RUA
///////----------- LABEL CEP
        JLabel lbn_cep = new JLabel("CEP:");
        lbn_cep.setBounds(740, 87, 46, 14);
        edit.add(lbn_cep);

///////----------- AREA DE TEXTO CEP	
        txt_cep = new JFormattedTextField();
        txt_cep.setColumns(10);
        txt_cep.setBounds(795, 84, 65, 20);
        edit.add(txt_cep);
        txt_cep.addFocusListener(new CaretPosition());
        try {
            mask_cep = new MaskFormatter("#####-###");
            mask_cep.install(txt_cep);
        } catch (ParseException ex) {
        }

///////---------------------------------------------------------------------------------------------- NUMERO
///////----------- LABEL NUMERO
        JLabel lbn_numero = new JLabel("NUMERO:");
        lbn_numero.setBounds(740, 117, 59, 14);
        edit.add(lbn_numero);
///////----------- AREA DE TEXTO NUMERO
        txt_numero = new JFormattedTextField();
        txt_numero.setColumns(10);
        txt_numero.setBounds(795, 114, 65, 20);
        edit.add(txt_numero);
        try {
            num = new MaskFormatter("##########");
            num.install(txt_numero);
        } catch (ParseException e) {
        }
        txt_numero.addFocusListener(new CaretPosition());
///////---------------------------------------------------------------------------------------------- BAIRRO
///////----------- LABEL BAIRRO
        JLabel lbn_bairro = new JLabel("BAIRRO:");
        lbn_bairro.setBounds(740, 147, 50, 14);
        edit.add(lbn_bairro);

///////----------- AREA DE TEXTO BAIRRO		
        txt_bairro = new JFormattedTextField();
        txt_bairro.setColumns(10);
        txt_bairro.setBounds(795, 144, 213, 20);
        edit.add(txt_bairro);
        txt_bairro.addFocusListener(new CaretPosition());
        try {
            namebairro = new MaskFormatter("******************************");
            namebairro.install(txt_bairro);
        } catch (ParseException e) {
        }

///////---------------------------------------------------------------------------------------------- ESTADO
///////----------- LABEL ESTADO
        JLabel lbn_estado = new JLabel("ESTADO:");
        lbn_estado.setBounds(740, 177, 59, 14);
        edit.add(lbn_estado);

        ///////----------- AREA DE TEXTO ESTADO	
        comboBox_estado.setModel(new DefaultComboBoxModel(new String[]{"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
        comboBox_estado.setBounds(795, 174, 97, 20);
        edit.add(comboBox_estado);

///////---------------------------------------------------------------------------------------------- CIDADE DO ENDERECO
///////----------- LABEL CIDADE DO ENDERECO
        JLabel lbn_cidade_endereco = new JLabel("CIDADE:");
        lbn_cidade_endereco.setBounds(740, 207, 59, 14);
        edit.add(lbn_cidade_endereco);

///////----------- AREA DE TEXTO CIDADE DO ENDERECO
        txt_cidade = new JFormattedTextField();
        txt_cidade.setColumns(10);
        txt_cidade.setBounds(795, 204, 213, 20);
        edit.add(txt_cidade);
        txt_cidade.addFocusListener(new CaretPosition());

///////---------------------------------------------------------------------------------------------- TELEFONE FIXO
///////----------- LABEL TELEFONE FIXO
        JLabel lbn_Telefone_fixo = new JLabel("TELEFONE FIXO:");
        lbn_Telefone_fixo.setBounds(7, 327, 96, 14);
        edit.add(lbn_Telefone_fixo);

///////----------- AREA DE TEXTO TELEFONE FIXO
        txt_telefone_fixo.setColumns(10);
        txt_telefone_fixo.setBounds(101, 324, 86, 20);
        edit.add(txt_telefone_fixo);
        txt_telefone_fixo.addFocusListener(new CaretPosition());
        try {
            mask_telfixo = new MaskFormatter("(##) ####-####");
            mask_telfixo.install(txt_telefone_fixo);
        } catch (ParseException ex) {
        }

///////---------------------------------------------------------------------------------------------- TELEFONE TELEFONE MOVEL
///////----------- LABEL TELEFONE MOVEL
        JLabel lbn_telefone_Movel = new JLabel("TELEFONE MOVEL:");
        lbn_telefone_Movel.setBounds(7, 357, 106, 14);
        edit.add(lbn_telefone_Movel);

///////----------- AREA DE TEXTO TELEFONE MOVEL
        txt_telefone_movel.setColumns(10);
        txt_telefone_movel.setBounds(121, 354, 86, 20);
        edit.add(txt_telefone_movel);
        txt_telefone_movel.addFocusListener(new CaretPosition());
        try {
            mask_telmovel = new MaskFormatter("(##) #####-####");
            mask_telmovel.install(txt_telefone_movel);
        } catch (ParseException ex) {
        }

///////---------------------------------------------------------------------------------------------- TELEFONE TELEFONE MOVEL
///////----------- LABEL EMAIL
        JLabel lbn_Email = new JLabel("EMAIL:");
        lbn_Email.setBounds(10, 387, 46, 14);
        edit.add(lbn_Email);

///////----------- AREA DE TEXTO EMAIL
        txt_email = new JFormattedTextField();
        txt_email.setColumns(10);
        txt_email.setBounds(50, 384, 315, 20);
        edit.add(txt_email);
        txt_email.addFocusListener(new CaretPosition());
        try {
            nameemail = new MaskFormatter("*************************************");
            nameemail.install(txt_email);
        } catch (ParseException e) {
        }
///////---------------------------------------------------------------------------------------------- BOTAO APLICAR

        btn_aplicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    modificar_Cadastro();
                    excluir_editar.setText("<html><font size=5 color=rgb(0,0,0)> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp      &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp ALTERADO COM SUCESSO<html>");
                } catch (ClassNotFoundException | SQLException e) {
                    // TODO Auto-generated catch block
                    excluir_editar.setText("<html><font size=5 color=rgb(0,0,0)> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp      &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp NÃO FOI POSSIVEL ALTERAR CADASTRO<html>");
                }
            }
        });
        JLabel text_aplicar = new JLabel("<html><font size=3 color=rgb(0,0,0)> &nbsp  &nbsp  APLICAR ALTERAÇÕES ");
        btn_aplicar.add(text_aplicar);
        btn_aplicar.setEnabled(false);
        btn_aplicar.setBackground(cor3);
        btn_aplicar.setBounds(894, 461, 150, 50);
        btn_aplicar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 100, 0), 2, true));
        b.add(btn_aplicar);
///////---------------------------------------------------------------------------------------------- BOTAO EXCLUIR CADASTRO

        btn_excluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    excluir_editar.setText("<html><font size=5 color=rgb(0,0,0)> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp      &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp CARREGANDO...<html>");
                    deletar_Registro();
                    excluir_editar.setText("<html><font size=5 color=rgb(0,0,0)> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp      &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp DELETADO COM SUCESSO<html>");
                } catch (ClassNotFoundException | SQLException e) {
                    // TODO Auto-generated catch block
                    excluir_editar.setText("<html><font size=5 color=rgb(0,0,0)> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp      &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp NÃO FOI POSSIVEL DELETAR CADASTRO<html>");
                }
            }
        });
        JLabel text_excluir = new JLabel("<html><font size=3 color=rgb(0,0,0)> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  EXCLUIR ");
        btn_excluir.add(text_excluir);
        btn_excluir.setEnabled(false);
        btn_excluir.setBackground(Color.RED);
        btn_excluir.setBounds(0, 461, 150, 50);
        btn_excluir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 0, 0), 2, true));
        b.add(btn_excluir);
        //---------------------------------------------------------------------//
    }

    public void janela4() throws UnexpectedException {

        if (dasfsd == 1) {
            f.add(c);
            c.setVisible(true);
            b.setVisible(false);
            a.setVisible(false);
            p.setVisible(false);
            d.setVisible(false);
            login.setVisible(false);
            c.setLayout(null);
            jb8.setBounds(0, 0, 60, 45);
            jb8.addActionListener(this);
            this.jb8.setBackground(cor2);
            jb8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
            c.add(jb8);
            c.add(adicionar_bd);
            adicionar_bd.setBounds(60, 0, 985, 45);
            adicionar_bd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
            adicionar_bd.setOpaque(true);
            adicionar_bd.setBackground(cor);
        }

        try {
            Connection con = new con_pack.ConnectionFactory().getConnection();
            if (dasfsd == 1) {
                PreparedStatement pesquisa = con.prepareStatement("Select Max(COD_CASO) from CASO ;");
                ResultSet totalbd2 = pesquisa.executeQuery();
                if (totalbd2.next()) {
                    int casomax = totalbd2.getInt("Max(COD_CASO)");
                    botoesN = new JButton[casomax + 1];
                }
                PreparedStatement pesquisa2 = con.prepareStatement("SELECT COUNT(COD_CASO) FROM CASO;");
                ResultSet totalbd = pesquisa2.executeQuery();
                if (totalbd.next()) {
                    countbd = totalbd.getInt("COUNT(COD_CASO)");
                    adicionar_bd.setText("<html><font size=6 color=rgb(0,0,0)>      &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp        Banco de Dados dos Infectados-total de cadastros:" + countbd);
                    dasfsd = 0;
                }

            }
            if (pesqok == 1) {
                PreparedStatement pesquisa2 = con.prepareStatement("SELECT COUNT(COD_CASO) FROM CASO INNER JOIN ENDERECO ON CASO.COD_CASO=FK_ENDERECO_CASO INNER JOIN CONTATO ON CASO.COD_CASO=CONTATO.FK_CONTATO_CASO " + countpesbd + ";");
                ResultSet totalbd = pesquisa2.executeQuery();
                if (totalbd.next()) {
                    countbd = totalbd.getInt("COUNT(COD_CASO)");
                    adicionar_bd.setText("<html><font size=6 color=rgb(0,0,0)>      &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp        Banco de Dados dos Infectados-total de cadastros:" + countbd);
                }
            }

            if (pesqok == 0) {
                pesquisab = con.prepareStatement("select CASO.*,DATE_FORMAT(DT_Nacimento,'%d/%m/%Y') AS data_formatada,DATE_FORMAT(DATA_REG,'%d/%m/%Y') AS data_formatada2,ENDERECO.*,CONTATO.TELEFONE_FIXO,CONTATO.TELEFONE_MOVEL,CONTATO.EMAIL FROM CASO INNER JOIN ENDERECO ON CASO.COD_CASO=FK_ENDERECO_CASO INNER JOIN CONTATO ON CASO.COD_CASO=CONTATO.FK_CONTATO_CASO WHERE CASO.COD_CASO>=" + casobd + " LIMIT 150;");
            }
            if (pesqok == 1) {
                pesquisab = con.prepareStatement(pesqbd + " AND CASO.COD_CASO>=" + casobd + " LIMIT 150;");
            }
            ResultSet resultado = pesquisab.executeQuery();
            int yconter = 250;
            String aumenta = "<html> <div height=350px width=10px></div>";
            Jbaroll.setText(aumenta);
            while (resultado.next()) {
                casobd = resultado.getString("COD_CASO");
                String nomebd = resultado.getString("NOME");
                String idadebd = resultado.getString("Idade");
                String databd = resultado.getString("data_formatada");
                String cpfbd = resultado.getString("CPF");
                String pesobd = resultado.getString("PESO");
                String alturabd = resultado.getString("ALTURA");
                String nome_mae_bd = resultado.getString("nome_mae");
                String nome_pai_bd = resultado.getString("NOME_PAI");
                String cidadebd = resultado.getString("CIDADE");
                String tipo_sanguineobd = resultado.getString("T_SANGUINEO");
                String cepbd = resultado.getString("CEP");
                String ruabd = resultado.getString("RUA");
                String numerobd = resultado.getString("NUMERO");
                String bairrobd = resultado.getString("BAIRRO");
                String estadobd = resultado.getString("ESTADO");
                String emailbd = resultado.getString("EMAIL");
                String rgbd = resultado.getString("RG");
                String telfixobd = resultado.getString("TELEFONE_FIXO");
                String telmovelbd = resultado.getString("TELEFONE_MOVEL");
                String datareg = resultado.getString("data_formatada2");
                String fatal = resultado.getString("FATAL");
                String caso_confirm = resultado.getString("CASO_CONFIRM");
                if (fatal.trim().equals("1") == true) {
                    fatal = "vivo";
                } else {
                    fatal = "morto";
                }
                if (caso_confirm.trim().equals("1") == true) {
                    caso_confirm = "confirmado";
                } else {
                    caso_confirm = "suspeita";
                }
                Jbaroll.add(usuariosbd = new JLabel("<html><font size=5 color=rgb(0,0,0)>" + " &nbsp nome:" + nomebd + " &nbsp idade:" + idadebd + " &nbsp data de nascimento:" + databd + " &nbsp CPF:" + cpfbd + "<br>" + " &nbsp peso:" + pesobd + " &nbsp altura:" + alturabd + "&nbsp tipo sanguineo:" + tipo_sanguineobd + " &nbsp telefone fixo:" + telfixobd + " &nbsp telefone movel:" + telmovelbd + "<br>" + " &nbsp email:" + emailbd + " &nbsp RG:" + rgbd + "<br>" + " &nbsp estado:" + estadobd + " &nbsp cidade:" + cidadebd + " &nbsp CEP:" + cepbd + " &nbsp rua:" + ruabd + "<br>" + " &nbsp bairro:" + bairrobd + " &nbsp numero:" + numerobd + "  data de registro:" + datareg + "  estado:" + fatal + "<br>" + " &nbsp nome da mãe:" + nome_mae_bd + " &nbsp nome do pai:" + nome_pai_bd + " &nbsp tipo de caso:" + caso_confirm + "<br>" + " &nbsp CASO NUMERO:" + casobd + "</html>"));
                Jbaroll.setText(aumenta);
                String casobt = casobd;
                botoesN[Integer.parseInt(casobd)] = new JButton("", pesquisar);
                usuariosbd.add(botoesN[Integer.parseInt(casobd)]);
                botoesN[Integer.parseInt(casobd)].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nro1 = 1;
                        pesqok = 0;
                        doabarroll.removeAll();
                        Jbaroll.removeAll();
                        c.removeAll();
                        dasfsd = 1;
                        p.remove(c);
                        mask_peso.uninstall();
                        mask_altura.uninstall();
                        mask_CPF.uninstall();
                        mask_telfixo.uninstall();
                        mask_telmovel.uninstall();
                        mask_RG.uninstall();
                        mask_cep.uninstall();
                        janela();
                        janela3();
                        txt_Codigo_cadastro.setText(casobt);
                        casobd = "0";
                        new Thread() {
                            public void run() {
                                try {
                                    excluir_editar.setText("<html><font size=5 color=rgb(0,0,0)> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp      &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp CARREGANDO...<html>");
                                    buscar_Dados(Integer.parseInt(txt_Codigo_cadastro.getText()));
                                    btn_aplicar.setEnabled(true);
                                    btn_excluir.setEnabled(true);
                                    txt_nome.setVisible(true);
                                    excluir_editar.setText("");
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "CODIGO DE CADASTRO INVALIDO OU INIXISTENTE");
                                }
                            }
                        }.start();
                    }
                });
                botoesN[Integer.parseInt(casobd)].setBounds(973, 122, 50, 50);
                aumenta = aumenta + "<div height=134px> </div>";
                usuariosbd.setBounds(0, yconter, 1050, 174);
                yconter = yconter + 174;
                usuariosbd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
            }
            Jbaroll.setBounds(0, 0, 0, 0);
            Jbaroll.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
            doabarroll = new JScrollPane(Jbaroll);
            doabarroll.getVerticalScrollBar().setUnitIncrement(15);
            doabarroll.setBorder(null);
            doabarroll.setBounds(0, 45, 1045, 467);
            c.add(doabarroll);
            textField_pesquisa = new JTextField();
            textField_pesquisa.setBounds(70, 11, 300, 20);
            Jbaroll.add(textField_pesquisa);
            textField_pesquisa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            textField_pesquisa.setColumns(10);
            Jbaroll.add(textnome);
            textnome.setBounds(5, 6, 60, 30);
            Jbaroll.add(tipo_sanguineo);
            tipo_sanguineo.setBounds(380, 7, 150, 30);
            Jbaroll.add(tipo_cidade);
            tipo_cidade.setBounds(630, 7, 110, 30);
            Jbaroll.add(sangue_pesquisa);
            sangue_pesquisa.removeAllItems();
            sangue_pesquisa.setBounds(530, 7, 80, 30);
            sangue_pesquisa.addItem("TODOS");
            sangue_pesquisa.addItem("A+");
            sangue_pesquisa.addItem("B+");
            sangue_pesquisa.addItem("AB+");
            sangue_pesquisa.addItem("O+");
            sangue_pesquisa.addItem("A-");
            sangue_pesquisa.addItem("B-");
            sangue_pesquisa.addItem("AB-");
            sangue_pesquisa.addItem("O-");
            sangue_pesquisa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            sangue_pesquisa.setSelectedItem("TODOS");
            cidade_box.removeAllItems();
            Jbaroll.add(cidade_box);
            cidade_box.setBounds(705, 7, 160, 30);
            cidade_box.addItem("TODAS");
            cidade_box.addItem("são bernado do campo");
            cidade_box.addItem("são paulo");
            cidade_box.addItem("mauá");
            cidade_box.addItem("são caetano");
            cidade_box.addItem("santo andré");
            cidade_box.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            Jbaroll.add(jbpesquisa);
            jbpesquisa.setBounds(870, 5, 155, 35);
            jbpesquisa.addActionListener(this);
            jbpesquisa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            Jbaroll.add(nextbd);
            nextbd.addActionListener(this);
            nextbd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 1, true));
            nextbd.setBounds(824, yconter, 200, 37);
            this.nextbd.setBackground(cor2);
            proxima_pagina.setIcon(nexticonbd);
            nextbd.add(proxima_pagina);
            formattedTextField_Peso.setBounds(60, 50, 42, 20);
            Jbaroll.add(formattedTextField_Altura);
            formattedTextField_Altura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            formattedTextField_Altura.setBounds(170, 50, 42, 20);
            Jbaroll.add(formattedTextField_Peso);
            formattedTextField_Peso.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            Jbaroll.add(textpeso);
            textpeso.setBounds(5, 50, 48, 20);
            Jbaroll.add(textaltura);
            textaltura.setBounds(110, 50, 60, 20);
            Jbaroll.add(textdatadenascimento);
            textdatadenascimento.setBounds(430, 50, 183, 20);
            spinnerDataDia.setToolTipText("DIA");
            spinnerDataDia.setBounds(611, 50, 35, 20);
            Jbaroll.add(spinnerDataDia);
            spinnerDataDia.setValue(0);
            spinnerDataDia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            spinnerDataMes.setToolTipText("MES");
            spinnerDataMes.setBounds(660, 50, 35, 20);
            Jbaroll.add(spinnerDataMes);
            spinnerDataMes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            spinnerDataMes.setValue(0);
            spinnerDataAno.setToolTipText("ANO");
            spinnerDataAno.setBounds(710, 50, 60, 20);
            spinnerDataAno.setValue(0);
            Jbaroll.add(spinnerDataAno);
            spinnerDataAno.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            textidade.setBounds(780, 50, 100, 20);
            spinner_Idade = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
            spinner_Idade.setBounds(840, 50, 70, 20);
            Jbaroll.add(spinner_Idade);
            Jbaroll.add(textidade);
            spinner_Idade.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            spinner_Idade.setValue(0);
            Jbaroll.add(email);
            email.setBounds(7, 73, 60, 30);
            emaildig = new JFormattedTextField();
            emaildig.setBounds(70, 80, 250, 20);
            emaildig.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            emaildig.setColumns(10);
            Jbaroll.add(emaildig);
            Jbaroll.add(telefonefixo);
            telefonefixo.setBounds(335, 73, 130, 30);
            formattedTextField_telfixo.setBounds(465, 80, 110, 20);
            Jbaroll.add(formattedTextField_telfixo);
            formattedTextField_telfixo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            Jbaroll.add(telefonemovel);
            telefonemovel.setBounds(580, 73, 145, 30);
            formattedTextField_telmovel.setBounds(730, 80, 120, 20);
            Jbaroll.add(formattedTextField_telmovel);
            formattedTextField_telmovel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            Jbaroll.add(RG);
            RG.setBounds(855, 73, 35, 30);
            formattedTextField_RG.setBounds(890, 80, 120, 20);
            Jbaroll.add(formattedTextField_RG);
            formattedTextField_RG.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            Jbaroll.add(estado);
            estado.setBounds(7, 114, 70, 30);
            estadodig = new JFormattedTextField();
            estadodig.setBounds(80, 119, 100, 20);
            estadodig.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            estadodig.setColumns(10);
            Jbaroll.add(estadodig);
            Jbaroll.add(RUA);
            RUA.setBounds(190, 114, 60, 30);
            ruadig = new JFormattedTextField();
            ruadig.setBounds(239, 119, 200, 20);
            ruadig.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            ruadig.setColumns(10);
            Jbaroll.add(ruadig);
            Jbaroll.add(BAIRRO);
            BAIRRO.setBounds(460, 114, 60, 30);
            bairrodig = new JFormattedTextField();
            bairrodig.setBounds(521, 119, 200, 20);
            bairrodig.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            bairrodig.setColumns(10);
            Jbaroll.add(bairrodig);
            Jbaroll.add(NUMERO);
            NUMERO.setBounds(730, 110, 200, 30);
            spinnernumero = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
            spinnernumero.setBounds(930, 119, 70, 20);
            spinnernumero.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            Jbaroll.add(spinnernumero);
            Jbaroll.add(CEP);
            CEP.setBounds(7, 150, 50, 30);
            formattedTextField_CEP.setBounds(60, 155, 120, 20);
            Jbaroll.add(formattedTextField_CEP);
            formattedTextField_CEP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            textField_mae = new JFormattedTextField();
            textField_mae.setBounds(320, 155, 300, 20);
            Jbaroll.add(textField_mae);
            textField_mae.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            textField_mae.setColumns(10);
            Jbaroll.add(textmae);
            textmae.setBounds(190, 150, 130, 30);
            textField_pai = new JFormattedTextField();
            textField_pai.setBounds(750, 155, 250, 20);
            Jbaroll.add(textField_pai);
            textField_pai.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            textField_pai.setColumns(10);
            Jbaroll.add(textpai);
            textpai.setBounds(630, 150, 130, 30);
            Jbaroll.add(NUMERO_caso);
            NUMERO_caso.setBounds(7, 185, 130, 30);
            spinnercaso = new JSpinner();
            spinnercaso.setBounds(140, 190, 70, 20);
            spinnercaso.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            Jbaroll.add(spinnercaso);
            try {
                mask_RG = new MaskFormatter("##.###.###-#");
                mask_RG.install(formattedTextField_RG);
            } catch (ParseException ex) {
            }
            try {
                mask_telfixo = new MaskFormatter("(##) ####-####");
                mask_telfixo.install(formattedTextField_telfixo);
            } catch (ParseException ex) {
            }
            try {
                mask_cep = new MaskFormatter("#####-###");
                mask_cep.install(formattedTextField_CEP);
            } catch (ParseException ex) {
            }
            try {
                mask_telmovel = new MaskFormatter("(##) #####-####");
                mask_telmovel.install(formattedTextField_telmovel);
            } catch (ParseException ex) {
            }
            try {
                mask_peso = new MaskFormatter("##.##");
                mask_peso.install(formattedTextField_Peso);
            } catch (ParseException ex) {
            }
            try {
                mask_altura = new MaskFormatter("#.##");
                mask_altura.install(formattedTextField_Altura);
            } catch (ParseException ex) {
            }
            Jbaroll.add(textcpf);
            textcpf.setBounds(220, 50, 50, 20);
            try {
                mask_CPF = new MaskFormatter("###.###.###-##");
                mask_CPF.install(formattedTextField_CPF);
            } catch (ParseException ex) {
            }
            formattedTextField_CPF.setBounds(270, 50, 150, 20);
            Jbaroll.add(formattedTextField_CPF);
            formattedTextField_CPF.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            Jbaroll.add(pagbd);
            pagbd.setBounds(3, yconter, 822, 37);
            pagbd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 3, true));
            pagbd.setOpaque(true);
            pagbd.setBackground(cor);
            if (countbd % 150 == 0) {
                dasfsdmax = countbd;
                pagbd.setText("<html><font size=5 color=rgb(0,0,0)>&nbsp  &nbsp  &nbsp &nbsp  &nbsp  &nbsp &nbsp  &nbsp  &nbsp &nbsp  &nbsp  &nbsp &nbsp  &nbsp  &nbsp &nbsp  &nbsp  &nbsp &nbsp  &nbsp  &nbsp &nbsp  &nbsp  &nbsp página " + ((dasfsd + 150) / 150) + " de " + (countbd / 150) + " . ");
            } else {
                dasfsdmax = ((countbd / 150) + 1) * 150;
                pagbd.setText("<html><font size=5 color=rgb(0,0,0)>&nbsp  &nbsp  &nbsp &nbsp  &nbsp  &nbsp &nbsp  &nbsp  &nbsp &nbsp  &nbsp  &nbsp &nbsp  &nbsp  &nbsp &nbsp  &nbsp  &nbsp &nbsp  &nbsp  &nbsp &nbsp  &nbsp  &nbsp página " + ((dasfsd + 150) / 150) + " de " + ((countbd / 150) + 1) + " . ");
            }
            if (nro1 == 1) {
                nro1 = 0;
                nro = new int[(dasfsdmax / 150) + 1];
                nro[0] = 0;
            }
            if (dasfsd > 0) {
                pagbd.setBounds(203, yconter, 623, 37);
                Jbaroll.add(backbd);
                backbd.addActionListener(this);
                backbd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 3, true));
                backbd.setBounds(4, yconter, 200, 37);
                this.backbd.setBackground(cor2);
                pagina_anterior.setIcon(backiconbd);
                backbd.add(pagina_anterior);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "erro de conexão");
        }

    }

    public void janela5() {
        f.add(d);
        d.setVisible(true);
        b.setVisible(false);
        a.setVisible(false);
        p.setVisible(false);
        c.setVisible(false);
        login.setVisible(false);
        d.setLayout(null);
        jb9.setBounds(0, 0, 60, 45);
        jb9.addActionListener(this);
        this.jb9.setBackground(cor2);
        jb9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
        d.add(adicionar_infectado);
        adicionar_infectado.setBounds(60, 0, 985, 45);
        adicionar_infectado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
        adicionar_infectado.setOpaque(true);
        adicionar_infectado.setBackground(cor);
        d.add(jb9);
        d.add(cadastrar);
        cadastrar.setBounds(894, 461, 150, 50);
        cadastrar.setBackground(cor2);
        cadastrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
        cadastrar.add(cadastro);
        cadastrar.addActionListener(this);
        d.add(cadastrob);
        cadastrob.setBounds(0, 461, 895, 50);
        cadastrob.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
        cadastrob.setOpaque(true);
        cadastrob.setBackground(cor);
        doabarollpesquisa = new JScrollPane(pesquisa_tamanho);
        doabarollpesquisa.getVerticalScrollBar().setUnitIncrement(15);
        doabarollpesquisa.setBorder(null);
        doabarollpesquisa.setBounds(0, 45, 1045, 416);
        d.add(doabarollpesquisa);
        pesquisa_tamanho.add(textcidade);
        textcidade.setBounds(740, 10, 100, 20);
        rdbtn_Cidade_1.setBounds(740, 35, 109, 23);
        pesquisa_tamanho.add(rdbtn_Cidade_1);
        rdbtn_Cidade_1.addActionListener(this);
        rdbtn_Cidade_2.setBounds(740, 65, 170, 23);
        pesquisa_tamanho.add(rdbtn_Cidade_2);
        rdbtn_Cidade_2.addActionListener(this);
        rdbtn_Cidade_3.setBounds(740, 95, 109, 23);
        pesquisa_tamanho.add(rdbtn_Cidade_3);
        rdbtn_Cidade_3.addActionListener(this);
        rdbtn_Cidade_4.setBounds(740, 125, 109, 23);
        pesquisa_tamanho.add(rdbtn_Cidade_4);
        rdbtn_Cidade_4.addActionListener(this);
        rdbtn_Cidade_5.setBounds(740, 155, 109, 23);
        pesquisa_tamanho.add(rdbtn_Cidade_5);
        rdbtn_Cidade_5.addActionListener(this);
        textnome.setBounds(7, 10, 100, 20);
        pesquisa_tamanho.add(texterro8);
        texterro8.setBounds(820, 10, 200, 20);
        texterro8.setVisible(false);
        textField_Nome = new JFormattedTextField();
        textField_Nome.addFocusListener(new CaretPosition());
        textField_Nome.setBounds(7, 35, 300, 20);
        pesquisa_tamanho.add(textField_Nome);
        textField_Nome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        textField_Nome.setColumns(10);
        pesquisa_tamanho.add(texterro);
        texterro.setBounds(320, 35, 200, 20);
        texterro.setVisible(false);
        pesquisa_tamanho.add(textnome);
        pesquisa_tamanho.add(textdatadenascimento);
        textdatadenascimento.setBounds(7, 65, 200, 20);
        spinnerDataDia.setToolTipText("DIA");
        spinnerDataDia.setBounds(7, 95, 35, 20);
        pesquisa_tamanho.add(spinnerDataDia);
        spinnerDataDia.setValue(1);
        spinnerDataDia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        spinnerDataMes.setToolTipText("MES");
        spinnerDataMes.setBounds(47, 95, 35, 20);
        pesquisa_tamanho.add(spinnerDataMes);
        spinnerDataMes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        spinnerDataMes.setValue(12);
        spinnerDataAno.setToolTipText("ANO");
        spinnerDataAno.setBounds(90, 95, 60, 20);
        spinnerDataAno.setValue(2000);
        pesquisa_tamanho.add(spinnerDataAno);
        spinnerDataAno.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pesquisa_tamanho.add(texterro3);
        texterro3.setBounds(160, 95, 200, 20);
        texterro3.setVisible(false);
        pesquisa_tamanho.add(textcpf);
        textcpf.setBounds(7, 125, 100, 20);
        formattedTextField_CPF.setBounds(7, 155, 150, 20);
        formattedTextField_CPF.addFocusListener(new CaretPosition());
        pesquisa_tamanho.add(formattedTextField_CPF);
        formattedTextField_CPF.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pesquisa_tamanho.add(RG);
        formattedTextField_RG.addFocusListener(new CaretPosition());
        RG.setBounds(180, 125, 35, 30);
        formattedTextField_RG.setBounds(180, 155, 120, 20);
        pesquisa_tamanho.add(formattedTextField_RG);
        formattedTextField_RG.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pesquisa_tamanho.add(texterro4);
        texterro4.setBounds(320, 155, 200, 20);
        texterro4.setVisible(false);
        pesquisa_tamanho.add(textpeso_altura);
        textpeso_altura.setBounds(7, 185, 150, 20);
        pesquisa_tamanho.add(textpeso);
        textpeso.setBounds(7, 215, 48, 20);
        pesquisa_tamanho.add(textaltura);
        textaltura.setBounds(110, 215, 60, 20);
        pesquisa_tamanho.add(texterro5);
        texterro5.setBounds(220, 215, 200, 20);
        texterro5.setVisible(false);
        formattedTextField_Peso.setBounds(61, 215, 42, 20);
        formattedTextField_Peso.addFocusListener(new CaretPosition());
        pesquisa_tamanho.add(formattedTextField_Altura);
        formattedTextField_Altura.addFocusListener(new CaretPosition());
        formattedTextField_Altura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        formattedTextField_Altura.setBounds(170, 215, 42, 20);
        pesquisa_tamanho.add(formattedTextField_Peso);
        formattedTextField_Peso.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pesquisa_tamanho.add(textmae);
        textmae.setBounds(7, 245, 240, 20);
        textField_mae = new JFormattedTextField();
        textField_mae.addFocusListener(new CaretPosition());
        textField_mae.setColumns(10);
        textField_mae.setBounds(7, 275, 300, 20);
        textField_mae.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pesquisa_tamanho.add(textField_mae);
        pesquisa_tamanho.add(texterro6);
        texterro6.setBounds(320, 275, 200, 20);
        texterro6.setVisible(false);
        pesquisa_tamanho.add(textpai);
        textpai.setBounds(7, 305, 240, 20);
        textField_pai = new JFormattedTextField();
        textField_pai.addFocusListener(new CaretPosition());
        textField_pai.setColumns(10);
        textField_pai.setBounds(7, 335, 300, 20);
        textField_pai.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pesquisa_tamanho.add(textField_pai);
        pesquisa_tamanho.add(texterro7);
        texterro7.setBounds(320, 335, 200, 20);
        texterro7.setVisible(false);
        pesquisa_tamanho.add(text_sangue);
        text_sangue.setBounds(740, 490, 240, 23);
        pesquisa_tamanho.add(sangue);
        sangue.setBounds(740, 520, 70, 20);
        sangue.removeAllItems();
        sangue.addItem("A+");
        sangue.addItem("B+");
        sangue.addItem("AB+");
        sangue.addItem("O+");
        sangue.addItem("A-");
        sangue.addItem("B-");
        sangue.addItem("AB-");
        sangue.addItem("O-");
        sangue.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pesquisa_tamanho.add(textvito);
        textvito.setBounds(740, 550, 200, 20);
        pesquisa_tamanho.add(estado_devida);
        pesquisa_tamanho.add(caso_conf);
        estado_devida.setBounds(740, 580, 70, 20);
        caso_conf.setBounds(740, 610, 110, 20);
        estado_devida.removeAllItems();
        caso_conf.removeAllItems();
        estado_devida.addItem("vivo");
        estado_devida.addItem("morto");
        caso_conf.addItem("suspeita");
        caso_conf.addItem("confirmado");
        estado_devida.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        caso_conf.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pesquisa_tamanho.add(email);
        email.setBounds(7, 365, 60, 30);
        pesquisa_tamanho.add(texterro9);
        emaildig = new JFormattedTextField();
        texterro9.setBounds(320, 395, 200, 20);
        texterro9.setVisible(false);
        emaildig.setBounds(7, 395, 300, 20);
        emaildig.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        emaildig.setColumns(10);
        emaildig.addFocusListener(new CaretPosition());
        pesquisa_tamanho.add(emaildig);
        pesquisa_tamanho.add(telefone);
        telefone.setBounds(7, 425, 200, 30);
        pesquisa_tamanho.add(fixo);
        fixo.setBounds(7, 455, 50, 30);
        formattedTextField_telfixo.setBounds(60, 461, 120, 21);
        formattedTextField_telfixo.addFocusListener(new CaretPosition());
        pesquisa_tamanho.add(formattedTextField_telfixo);
        formattedTextField_telfixo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pesquisa_tamanho.add(movel);
        movel.setBounds(190, 455, 80, 30);
        formattedTextField_telmovel.setBounds(270, 461, 120, 21);
        formattedTextField_telmovel.addFocusListener(new CaretPosition());
        pesquisa_tamanho.add(formattedTextField_telmovel);
        formattedTextField_telmovel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pesquisa_tamanho.add(texterro10);
        texterro10.setBounds(400, 460, 200, 20);
        texterro10.setVisible(false);
        pesquisa_tamanho.add(estado);
        estado.setBounds(740, 185, 70, 30);
        JLabel estado = new JLabel();
        estado.setText("SP");
        pesquisa_tamanho.add(texterro11);
        texterro11.setBounds(810, 190, 200, 20);
        texterro11.setVisible(false);
        estado.setBounds(740, 215, 100, 20);
        estado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pesquisa_tamanho.add(estado);
        pesquisa_tamanho.add(RUA);
        pesquisa_tamanho.add(texterro12);
        texterro12.setBounds(790, 250, 200, 20);
        texterro12.setVisible(false);
        RUA.setBounds(740, 245, 60, 30);
        ruadig = new JFormattedTextField();
        ruadig.addFocusListener(new CaretPosition());
        ruadig.setBounds(740, 275, 200, 20);
        ruadig.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        ruadig.setColumns(10);
        pesquisa_tamanho.add(ruadig);
        pesquisa_tamanho.add(BAIRRO);
        pesquisa_tamanho.add(texterro13);
        texterro13.setBounds(799, 310, 200, 20);
        texterro13.setVisible(false);
        BAIRRO.setBounds(740, 305, 60, 30);
        bairrodig = new JFormattedTextField();
        bairrodig.addFocusListener(new CaretPosition());
        bairrodig.setBounds(740, 340, 200, 20);
        bairrodig.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        bairrodig.setColumns(10);
        pesquisa_tamanho.add(bairrodig);
        pesquisa_tamanho.add(NUMERO);
        NUMERO.setBounds(740, 430, 200, 30);
        pesquisa_tamanho.add(CEP);
        CEP.setBounds(740, 370, 200, 30);
        pesquisa_tamanho.add(texterro2);
        texterro2.setBounds(800, 375, 200, 20);
        texterro2.setVisible(false);
        pesquisa_tamanho.add(formattedTextField_CEP);
        formattedTextField_CEP.setBounds(740, 400, 200, 20);
        formattedTextField_CEP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        formattedTextField_CEP.addFocusListener(new CaretPosition());
        spinnernumero = new JSpinner(new SpinnerNumberModel(1, 1, null, 1));
        spinnernumero.setBounds(740, 460, 70, 20);
        spinnernumero.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pesquisa_tamanho.add(spinnernumero);
        try {
            name = new MaskFormatter("******************************");
            name.setValidCharacters("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZÁáÂâÀ àÃãÊêÈèÉéÍíÎîÌìÓóÔôÒòÚúÛûÙùÝý");
            name.install(textField_Nome);

        } catch (ParseException e) {
        }
        try {
            nameestado = new MaskFormatter("******************************");
            nameestado.setValidCharacters("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZÁáÂâÀ àÃãÊêÈèÉéÍíÎîÌìÓóÔôÒòÚúÛûÙùÝý");
            nameestado.install(estadodig);
        } catch (ParseException e) {
        }
        try {
            namerua = new MaskFormatter("******************************");
            namerua.install(ruadig);
        } catch (ParseException e) {
        }
        try {
            namebairro = new MaskFormatter("******************************");
            namebairro.install(bairrodig);
        } catch (ParseException e) {
        }
        try {
            namepai = new MaskFormatter("******************************");
            namepai.setValidCharacters("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZÁáÂâÀ àÃãÊêÈèÉéÍíÎîÌìÓóÔôÒòÚúÛûÙùÝý");
            namepai.install(textField_pai);
        } catch (ParseException e) {
        }
        try {
            namemae = new MaskFormatter("******************************");
            namemae.setValidCharacters("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZÁáÂâÀ àÃãÊêÈèÉéÍíÎîÌìÓóÔôÒòÚúÛûÙùÝý");
            namemae.install(textField_mae);
        } catch (ParseException e) {
        }

        try {
            nameemail = new MaskFormatter("*************************************");
            nameemail.install(emaildig);
        } catch (ParseException e) {
        }

        try {
            mask_RG = new MaskFormatter("##.###.###-#");
            mask_RG.install(formattedTextField_RG);
        } catch (ParseException ex) {
        }
        try {
            mask_telfixo = new MaskFormatter("(##) ####-####");
            mask_telfixo.install(formattedTextField_telfixo);
        } catch (ParseException ex) {
        }
        try {
            mask_cep = new MaskFormatter("#####-###");
            mask_cep.install(formattedTextField_CEP);
        } catch (ParseException ex) {
        }
        try {
            mask_telmovel = new MaskFormatter("(##) #####-####");
            mask_telmovel.install(formattedTextField_telmovel);
        } catch (ParseException ex) {
        }
        try {
            mask_peso = new MaskFormatter("##.##");
            mask_peso.install(formattedTextField_Peso);
        } catch (ParseException ex) {
        }
        try {
            mask_altura = new MaskFormatter("#.##");
            mask_altura.install(formattedTextField_Altura);
        } catch (ParseException ex) {
        }

        try {
            mask_CPF = new MaskFormatter("###.###.###-##");
            mask_CPF.install(formattedTextField_CPF);
        } catch (ParseException ex) {
        }
    }

    public void graph() {
        DefaultPieDataset pizza = new DefaultPieDataset();
        int populacao = 736466 - totalcasos[1][1];
        pizza.setValue("população", populacao);
        pizza.setValue("infectados", totalcasos[1][1]);
        JFreeChart grafico = ChartFactory.createPieChart("são bernado do campo", pizza, true, true, false);
        doencas2 = new ChartPanel(grafico);
        doencas2.setBounds(1, 650, 450, 500);
        text.add(doencas2);
        DefaultPieDataset pizza2 = new DefaultPieDataset();
        int populacao2 = 12180000 - totalcasos[1][4];
        pizza2.setValue("população", populacao2);
        pizza2.setValue("infectados", totalcasos[1][4]);
        JFreeChart grafico2 = ChartFactory.createPieChart("são Paulo", pizza2, true, true, false);
        doencas2 = new ChartPanel(grafico2);
        doencas2.setBounds(500, 650, 450, 500);
        text.add(doencas2);
        DefaultPieDataset pizza3 = new DefaultPieDataset();
        int populacao3 = 417064 - totalcasos[1][3];
        pizza3.setValue("população", populacao3);
        pizza3.setValue("infectados", totalcasos[1][3]);
        JFreeChart grafico3 = ChartFactory.createPieChart("mauá", pizza3, true, true, false);
        doencas3 = new ChartPanel(grafico3);
        doencas3.setBounds(1, 1200, 450, 500);
        text.add(doencas3);
        DefaultPieDataset pizza4 = new DefaultPieDataset();
        int populacao4 = 568538 - totalcasos[1][2];
        pizza4.setValue("população", populacao4);
        pizza4.setValue("infectados", totalcasos[1][2]);
        JFreeChart grafico4 = ChartFactory.createPieChart("santo andré", pizza4, true, true, false);
        doencas4 = new ChartPanel(grafico4);
        doencas4.setBounds(500, 1200, 450, 500);
        text.add(doencas4);
        DefaultPieDataset pizza5 = new DefaultPieDataset();
        int populacao5 = 149263 - totalcasos[1][5];
        pizza5.setValue("população", populacao5);
        pizza5.setValue("infectados", totalcasos[1][5]);
        JFreeChart grafico5 = ChartFactory.createPieChart("são caetano", pizza5, true, true, false);
        doencas5 = new ChartPanel(grafico5);
        doencas5.setBounds(1, 1700, 1000, 500);
        text.add(doencas5);
    }

    public void graphbar() {
        DefaultCategoryDataset bar = new DefaultCategoryDataset();
        bar.setValue(i, "corona", "");
        bar.setValue(20, "aids", "");
        bar.setValue(70, "HIV", "");
        JFreeChart graphbar = ChartFactory.createBarChart3D("doenças", "infectados", "pessoas", bar, PlotOrientation.VERTICAL, true, true, false);
        doencas2 = new ChartPanel(graphbar);
        doencas2.setBounds(0, 60, 1050, 450);
        b.add(doencas2);
    }

    public void buscar_Dados(int COD_CASO) {

        try {
            Connection connection = conexao.getInstance().getConnection();
            String sql = String.format("SELECT * FROM CASO,ENDERECO,CONTATO WHERE COD_CASO=%s AND ENDERECO.FK_ENDERECO_CASO=%s AND CONTATO.FK_CONTATO_CASO=%s; ", COD_CASO, COD_CASO, COD_CASO);
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();
            if ((comboBox_estado.getSelectedItem().equals("cidade 1") == false)) {
                if (resultset.next()) {
                    //CIDADE DE REGISTRO
                    switch (resultset.getInt("FK_CASO_ESTADO")) {
                        case 11:
                            comboBox_cidade.setSelectedItem("cidade 3");
                            break;
                        case 22:
                            comboBox_cidade.setSelectedItem("cidade 2");
                            break;
                        case 33:
                            comboBox_cidade.setSelectedItem("cidade 1");
                            break;
                        case 44:
                            comboBox_cidade.setSelectedItem("cidade 4");
                            break;
                        case 55:
                            comboBox_cidade.setSelectedItem("cidade 5");
                            break;
                    }

                    txt_nome.setText(resultset.getString("NOME"));
                    spinner_Idaded.setValue(resultset.getInt("Idade"));
                    //data de nascimento
                    String data = resultset.getString("DT_Nacimento");
                    spinner_Nascimento_Dia.setValue(Integer.parseInt(data.substring(8, 10)));
                    spinner_Nacimento_Mes.setValue(Integer.parseInt(data.substring(5, 7)));
                    spinner_Nascimento_Ano.setValue(Integer.parseInt(data.substring(0, 4)));
                    formatted_txt_cpf.setText(resultset.getString("CPF"));
                    formatted_txt_rg.setText(resultset.getString("RG"));
                    txt_peso.setText(resultset.getString("PESO"));
                    txt_altura.setText(resultset.getString("ALTURA"));
                    comboBox_tipo_sanguineo.setSelectedItem(resultset.getString("T_SANGUINEO"));
                    text_Nome_pai.setText(resultset.getString("NOME_PAI"));
                    txt_nome_mae.setText(resultset.getString("NOME_MAE"));
                    txt_cep.setText(resultset.getString("CEP"));
                    txt_rua.setText(resultset.getString("RUA"));
                    txt_numero.setText(resultset.getString("NUMERO"));
                    txt_bairro.setText(resultset.getString("BAIRRO"));
                    txt_cidade.setText(resultset.getString("CIDADE"));
                    comboBox_estado.setSelectedItem(resultset.getString("ESTADO"));
                    txt_telefone_fixo.setText(resultset.getString("TELEFONE_FIXO"));
                    txt_telefone_movel.setText(resultset.getString("TELEFONE_MOVEL"));
                    txt_email.setText(resultset.getString("EMAIL"));
                    connection.close();
                } else {
                    JOptionPane.showMessageDialog(null, "CODIGO NAO REGISTRADO");
                    connection.close();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
////////////////////////// PARTE QUE DELETA O GEISTRO /////////////////////////////////////////

    public void deletar_Registro() throws ClassNotFoundException, SQLException {
        Connection connection;
        try {
            connection = conexao.getInstance().getConnection();

            String sql1 = String.format("DELETE FROM ENDERECO WHERE FK_ENDERECO_CASO=%s;", Integer.parseInt(txt_Codigo_cadastro.getText()));
            String sql2 = String.format("DELETE FROM CONTATO WHERE FK_CONTATO_CASO=%S;", Integer.parseInt(txt_Codigo_cadastro.getText()));
            String sql3 = String.format("DELETE FROM CASO WHERE COD_CASO=%S;", Integer.parseInt(txt_Codigo_cadastro.getText()));
            PreparedStatement statement = connection.prepareStatement(sql1);
            statement.execute();
            PreparedStatement statement2 = connection.prepareStatement(sql2);
            statement2.execute();
            PreparedStatement statement3 = connection.prepareStatement(sql3);
            statement3.execute();
            connection.close();
            JOptionPane.showMessageDialog(null, "registro deletado");
        } catch (UnexpectedException ex) {
            Logger.getLogger(drink.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//////////////////////////// MODIFICAR CADASTRO///////////////////////////////////////////
    public void modificar_Cadastro() throws ClassNotFoundException, SQLException {

        String data = spinner_Nascimento_Ano.getValue() + "-" + spinner_Nacimento_Mes.getValue() + "-" + spinner_Nascimento_Dia.getValue();
        int Cod_cidade = 0;
        if ((comboBox_cidade.getSelectedItem().equals("cidade 1") == true)) {
            Cod_cidade = 11;
        } else if (comboBox_cidade.getSelectedItem().equals("cidade 2") == true) {
            Cod_cidade = 22;
        } else if (comboBox_cidade.getSelectedItem().equals("cidade 3") == true) {
            Cod_cidade = 33;
        } else if (comboBox_cidade.getSelectedItem().equals("cidade 4") == true) {
            Cod_cidade = 44;
        } else if (comboBox_cidade.getSelectedItem().equals("cidade 5") == true) {
            Cod_cidade = 55;
        }
        Connection connection;
        try {
            connection = conexao.getInstance().getConnection();

            String sql_1 = String.format("UPDATE CASO SET NOME='%s',Idade=%s,DT_Nacimento='%s',CPF='%s',RG='%s',PESO=%s,ALTURA=%s,T_SANGUINEO='%s',NOME_PAI='%s',NOME_MAE='%s',FK_CASO_ESTADO=%s WHERE COD_CASO=%s",
                    txt_nome.getText(),
                    spinner_Idaded.getValue(),
                    data,
                    formatted_txt_rg.getText(),
                    formatted_txt_rg.getText(),
                    Double.parseDouble(txt_peso.getText()),
                    Double.parseDouble(txt_altura.getText()),
                    comboBox_tipo_sanguineo.getSelectedItem().toString(),
                    text_Nome_pai.getText(),
                    txt_nome_mae.getText(),
                    Cod_cidade,
                    txt_Codigo_cadastro.getText()
            );

            ////// ALTERA TABELA ENDERECO
            String sql_2 = String.format("UPDATE ENDERECO SET CEP='%s',RUA='%s',NUMERO=%s,BAIRRO='%s',ESTADO='%s',CIDADE='%s' WHERE FK_ENDERECO_CASO=%s;",
                    txt_cep.getText(),
                    txt_rua.getText(),
                    txt_numero.getText(),
                    txt_bairro.getText(),
                    comboBox_estado.getSelectedItem(),
                    txt_cidade.getText(),
                    txt_Codigo_cadastro.getText()
            );

            /////// ALTERA CONTATO
            String sql_3 = String.format("UPDATE CONTATO SET TELEFONE_FIXO='%s',TELEFONE_MOVEL='%s',EMAIL='%s' WHERE FK_CONTATO_CASO=%s;", txt_telefone_fixo.getText(), txt_telefone_movel.getText(), txt_email.getText(), txt_Codigo_cadastro.getText());

            PreparedStatement statement_1 = connection.prepareStatement(sql_1);
            statement_1.execute();
            PreparedStatement statement_2 = connection.prepareStatement(sql_2);
            statement_2.execute();
            PreparedStatement statement_3 = connection.prepareStatement(sql_3);
            statement_3.execute();
            connection.close();
        } catch (UnexpectedException ex) {
            Logger.getLogger(drink.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        drink drink = new drink();
    
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jb1) {
            janela2();
        }
        if (e.getSource() == jb2) {
            login();
            tela = 1;
        }
        if (e.getSource() == jb3) {
            login();
            tela = 2;

        }
        if (e.getSource() == jb4) {
            janela5();
        }
        if (e.getSource() == jb6) {
            text.removeAll();
            barroll.removeAll();
            a.removeAll();
            p.remove(a);
            janela();
        }
        if (e.getSource() == jb7) {
            doabarrolledit.removeAll();
            edit.removeAll();
            janela();
            b.removeAll();
            p.remove(b);
            mask_peso.uninstall();
            mask_altura.uninstall();
            mask_CPF.uninstall();
            mask_telfixo.uninstall();
            mask_telmovel.uninstall();
            mask_RG.uninstall();
            mask_cep.uninstall();
        }
        if (e.getSource() == jb8) {
            casobd = "0";
            nro1 = 1;
            pesqok = 0;
            doabarroll.removeAll();
            Jbaroll.removeAll();
            c.removeAll();
            dasfsd = 1;
            p.remove(c);
            mask_peso.uninstall();
            mask_altura.uninstall();
            mask_CPF.uninstall();
            mask_telfixo.uninstall();
            mask_telmovel.uninstall();
            mask_RG.uninstall();
            mask_cep.uninstall();
            janela();
        }
        if (e.getSource() == jb9) {
            cadastrar.removeActionListener(this);
            pesquisa_tamanho.removeAll();
            d.removeAll();
            sangue.removeAllItems();
            janela();
            mask_peso.uninstall();
            mask_altura.uninstall();
            mask_CPF.uninstall();
            mask_telfixo.uninstall();
            mask_telmovel.uninstall();
            mask_RG.uninstall();
            mask_cep.uninstall();
            name.uninstall();
            namepai.uninstall();
            namemae.uninstall();
            namerua.uninstall();
            namebairro.uninstall();
            nameestado.uninstall();
            nameemail.uninstall();
            cadastrob.setText("");
            p.remove(d);
        }
        if (e.getSource() == jb10) {
            login.removeAll();
            p.remove(login);
            janela();
        }
        if (e.getSource() == entrar) {
            String senha = new String(formattedTextField_senha.getPassword());
            if (formattedTextField_login.getText().equals("root") && senha.equals("admin")) {
                login.removeAll();
                p.remove(login);
                if (tela == 1) {
                    janela3();
                }
                if (tela != 1) {
                    try {
                        janela4();
                    } catch (UnexpectedException ex) {
                        Logger.getLogger(drink.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            } else {
                if (formattedTextField_login.getText().equals("root") == false) {
                    erlogin.setVisible(true);
                } else {
                    erlogin.setVisible(false);
                }
                if (senha.equals("admin") == false) {
                    ersenha.setVisible(true);
                } else {
                    ersenha.setVisible(false);
                }
            }
            e.setSource(null);
        }

        if (e.getSource() == nextbd) {

            if (dasfsdmax > dasfsd + 150) {
                if (pesqok == 1) {
                    nro[(dasfsd + 150) / 150] = Integer.parseInt(casobd);
                }
                dasfsd = dasfsd + 150;
                proxima_pagina.removeAll();
                nextbd.removeAll();
                Jbaroll.removeAll();
                doabarroll.removeAll();
                c.remove(doabarroll);
                mask_peso.uninstall();
                mask_altura.uninstall();
                mask_CPF.uninstall();
                mask_telfixo.uninstall();
                mask_telmovel.uninstall();
                mask_RG.uninstall();
                mask_cep.uninstall();
                try {
                    janela4();
                } catch (UnexpectedException ex) {
                    Logger.getLogger(drink.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            e.setSource(null);
        }
        if (e.getSource() == jbpesquisa) {
            dasfsd = 0;
            nro1 = 1;
            casobd = "0";
            pesqbd = "select CASO.*,DATE_FORMAT(DT_Nacimento,'%d/%m/%Y') AS data_formatada,DATE_FORMAT(DATA_REG,'%d/%m/%Y') AS data_formatada2,ENDERECO.*,CONTATO.TELEFONE_FIXO,CONTATO.TELEFONE_MOVEL,CONTATO.EMAIL FROM CASO INNER JOIN ENDERECO ON CASO.COD_CASO=FK_ENDERECO_CASO INNER JOIN CONTATO ON CASO.COD_CASO=CONTATO.FK_CONTATO_CASO WHERE CASO.COD_CASO>=0 ";
            String casobd2 = spinnercaso.getValue().toString();
            if (casobd2.equals("0") == false) {
                pesqbd = pesqbd + " AND CASO.COD_CASO=" + casobd2;
            }
            String nomebd = textField_pesquisa.getText().trim();
            if (nomebd.equals("") == false) {
                pesqbd = pesqbd + " AND CASO.NOME='" + nomebd + "'";
            }
            String databd = spinnerDataDia.getValue().toString();
            String databd2 = spinnerDataMes.getValue().toString();
            String databd3 = spinnerDataAno.getValue().toString();
            if (databd3.equals("0") == false && databd2.equals("0") == false && databd.equals("0") == false) {
                pesqbd = pesqbd + " AND CASO.DT_Nacimento='" + databd3 + "-" + databd2 + "-" + databd + "'";
            }
            String idadebd = spinner_Idade.getValue().toString();
            if (idadebd.equals("0") == false) {
                pesqbd = pesqbd + " AND CASO.Idade=" + idadebd;
            }
            String cpfbd = formattedTextField_CPF.getText().trim();
            if (cpfbd.length() == 14) {
                pesqbd = pesqbd + " AND CASO.CPF='" + cpfbd + "'";
            }
            String pesobd = formattedTextField_Peso.getText().trim();
            if (pesobd.length() == 5) {
                pesqbd = pesqbd + " AND CASO.PESO=" + pesobd;
            }
            String alturabd = formattedTextField_Altura.getText().trim();
            if (alturabd.length() == 4) {
                pesqbd = pesqbd + " AND CASO.ALTURA=" + alturabd;
            }
            String nome_mae_bd = textField_mae.getText().trim();
            if (nome_mae_bd.equals("") == false) {
                pesqbd = pesqbd + " AND CASO.NOME_MAE='" + nome_mae_bd + "'";
            }
            String nome_pai_bd = textField_pai.getText().trim();
            if (nome_pai_bd.equals("") == false) {
                pesqbd = pesqbd + " AND CASO.NOME_PAI='" + nome_pai_bd + "'";
            }
            String tipo_sanguineobd = sangue_pesquisa.getSelectedItem().toString();
            if (tipo_sanguineobd.equals("TODOS") == false) {
                pesqbd = pesqbd + " AND T_SANGUINEO='" + tipo_sanguineobd + "'";
            }
            String cidade_boxbd = cidade_box.getSelectedItem().toString();
            if (cidade_boxbd.equals("TODAS") == false) {
                pesqbd = pesqbd + " AND CIDADE='" + cidade_boxbd + "'";
            }
            String cepbd = formattedTextField_CEP.getText().trim();
            if (cepbd.length() == 9) {
                pesqbd = pesqbd + " AND ENDERECO.CEP='" + cepbd + "'";
            }
            String ruabd = ruadig.getText().trim();
            if (ruabd.equals("") == false) {
                pesqbd = pesqbd + " AND ENDERECO.RUA='" + ruabd + "'";
            }
            String numerobd = spinnernumero.getValue().toString();
            if (numerobd.equals("0") == false) {
                pesqbd = pesqbd + " AND ENDERECO.NUMERO=" + numerobd;
            }
            String bairrobd = bairrodig.getText().trim();
            if (bairrobd.equals("") == false) {
                pesqbd = pesqbd + " AND ENDERECO.BAIRRO='" + bairrobd + "'";
            }
            String estadobd = estadodig.getText().trim();
            if (estadobd.equals("") == false) {
                pesqbd = pesqbd + " AND ENDERECO.ESTADO='" + estadobd + "'";
            }
            String emailbd = emaildig.getText().trim();
            if (emailbd.equals("") == false) {
                pesqbd = pesqbd + " AND CONTATO.EMAIL='" + emailbd + "'";
            }
            String rgbd = formattedTextField_RG.getText().trim();
            if (rgbd.length() == 12) {
                pesqbd = pesqbd + " AND CASO.RG='" + rgbd + "'";
            }
            String telfixobd = formattedTextField_telfixo.getText().trim();
            if (telfixobd.length() == 14) {
                pesqbd = pesqbd + " AND CONTATO.TELEFONE_FIXO='" + telfixobd + "'";
            }
            String telmovelbd = formattedTextField_telmovel.getText().trim();
            if (telmovelbd.length() == 15) {
                pesqbd = pesqbd + " AND CONTATO.TELEFONE_MOVEL='" + telmovelbd + "'";
            }
            countpesbd = pesqbd.substring(314, pesqbd.length());
            pesqok = 1;
            proxima_pagina.removeAll();
            nextbd.removeAll();
            Jbaroll.removeAll();
            doabarroll.removeAll();
            c.remove(doabarroll);
            mask_peso.uninstall();
            mask_altura.uninstall();
            mask_CPF.uninstall();
            mask_telfixo.uninstall();
            mask_telmovel.uninstall();
            mask_RG.uninstall();
            mask_cep.uninstall();
            try {
                janela4();
            } catch (UnexpectedException ex) {
            }
            e.setSource(null);
        }
        if (e.getSource() == backbd) {

            casobd = Integer.toString(nro[((dasfsd) / 150) - 1]);
            dasfsd = dasfsd - 150;
            proxima_pagina.removeAll();
            nextbd.removeAll();
            Jbaroll.removeAll();
            doabarroll.removeAll();
            c.remove(doabarroll);
            mask_peso.uninstall();
            mask_altura.uninstall();
            mask_CPF.uninstall();
            mask_telfixo.uninstall();
            mask_telmovel.uninstall();
            mask_RG.uninstall();
            mask_cep.uninstall();
            try {
                janela4();
            } catch (UnexpectedException ex) {
                Logger.getLogger(drink.class.getName()).log(Level.SEVERE, null, ex);
            }
            e.setSource(null);
        }
        if (rdbtn_Cidade_5.isSelected() == true && e.getSource() == rdbtn_Cidade_5) {
            rdbtn_Cidade_1.setSelected(false);
            rdbtn_Cidade_2.setSelected(false);
            rdbtn_Cidade_3.setSelected(false);
            rdbtn_Cidade_4.setSelected(false);
            cidadenome = "mauá";
        }
        if (rdbtn_Cidade_4.isSelected() == true && e.getSource() == rdbtn_Cidade_4) {
            rdbtn_Cidade_1.setSelected(false);
            rdbtn_Cidade_2.setSelected(false);
            rdbtn_Cidade_3.setSelected(false);
            rdbtn_Cidade_5.setSelected(false);
            cidadenome = "são caetano";

        }
        if (rdbtn_Cidade_3.isSelected() == true && e.getSource() == rdbtn_Cidade_3) {
            rdbtn_Cidade_1.setSelected(false);
            rdbtn_Cidade_2.setSelected(false);
            rdbtn_Cidade_4.setSelected(false);
            rdbtn_Cidade_5.setSelected(false);
            cidadenome = "santo andré";

        }
        if (rdbtn_Cidade_2.isSelected() == true && e.getSource() == rdbtn_Cidade_2) {
            rdbtn_Cidade_1.setSelected(false);
            rdbtn_Cidade_3.setSelected(false);
            rdbtn_Cidade_4.setSelected(false);
            rdbtn_Cidade_5.setSelected(false);
            cidadenome = "são bernado do campo";

        }
        if (rdbtn_Cidade_1.isSelected() == true && e.getSource() == rdbtn_Cidade_1) {
            rdbtn_Cidade_2.setSelected(false);
            rdbtn_Cidade_3.setSelected(false);
            rdbtn_Cidade_4.setSelected(false);
            rdbtn_Cidade_5.setSelected(false);
            cidadenome = "são paulo";

        }
        if (e.getSource() == cadastrar) {
            String nome = textField_Nome.getText().trim();
            cadastrob.setText("");
            if (nome.isEmpty()) {
                texterro.setVisible(true);
                txe1 = 0;
            } else {
                texterro.setVisible(false);
                txe1 = 1;
            }
            String nomemae = textField_mae.getText().trim();
            if (nomemae.isEmpty()) {
                texterro6.setVisible(true);
                txe6 = 0;
            } else {
                texterro6.setVisible(false);
                txe6 = 1;
            }
            String nomepai = textField_pai.getText().trim();
            if (nomepai.isEmpty()) {
                texterro7.setVisible(true);
                txe7 = 0;
            } else {
                texterro7.setVisible(false);
                txe7 = 1;
            }
            String nomeemail = emaildig.getText().trim();
            if (nomeemail.isEmpty()) {
                texterro9.setVisible(true);
                txe9 = 0;
            } else {
                texterro9.setVisible(false);
                txe9 = 1;
            }

            String dia = spinnerDataDia.getValue().toString();
            String mes = spinnerDataMes.getValue().toString();
            String ano = spinnerDataAno.getValue().toString();
            int ano2 = Integer.parseInt(ano);
            if (ano2 <= 2020) {
                String s = dia + "/" + mes + "/" + ano;
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                df.setLenient(false);
                try {
                    df.parse(s);
                    texterro3.setVisible(false);
                    GregorianCalendar hoje = new GregorianCalendar();
                    diah = hoje.get(Calendar.DAY_OF_MONTH);
                    mesh = hoje.get(Calendar.MONTH) + 1;
                    anoh = hoje.get(Calendar.YEAR);
                    int dian = Integer.parseInt(dia);
                    int mesn = Integer.parseInt(mes);
                    int anon = Integer.parseInt(ano);
                    if (mesn < mesh || (mesn == mesh && dian <= diah)) // descobre a idade pela data de nascimento
                    {
                        idade = anoh - anon;
                    } else {
                        idade = (anoh - anon) - 1;
                    }
                    if (idade < 0 | idade > 130) {
                        texterro3.setVisible(true);
                        txe3 = 0;
                    } //verifica se idade está entre 0 a 130 anos
                    txe3 = 1;
                } catch (ParseException ex) {
                    texterro3.setVisible(true);
                    txe3 = 0;
                }
            } else {
                texterro3.setVisible(true);
                txe3 = 0;
            }
            String namecpf = formattedTextField_CPF.getText().trim();
            String namerg = formattedTextField_RG.getText().trim();
            if (formattedTextField_CPF.getText().trim().length() < 14 | formattedTextField_RG.getText().trim().length() < 12) {
                texterro4.setVisible(true);
                txe4 = 0;
            } else {
                texterro4.setVisible(false);
                txe4 = 1;
            }
            String namepeso = formattedTextField_Peso.getText().trim();
            String namealtura = formattedTextField_Altura.getText().trim();
            if (formattedTextField_Peso.getText().trim().length() < 5 || formattedTextField_Altura.getText().trim().length() < 4) {
                texterro5.setVisible(true);
                txe5 = 0;
            } else {
                texterro5.setVisible(false);
                txe5 = 1;
            }
            if (rdbtn_Cidade_5.isSelected() == false && rdbtn_Cidade_4.isSelected() == false && rdbtn_Cidade_3.isSelected() == false && rdbtn_Cidade_2.isSelected() == false && rdbtn_Cidade_1.isSelected() == false) {
                texterro8.setVisible(true);
                txe8 = 0;
            } else {
                texterro8.setVisible(false);
                txe8 = 1;
            }
            String nometelfixo = formattedTextField_telfixo.getText().trim();
            String nometelmovel = formattedTextField_telmovel.getText().trim();
            if (nometelfixo.length() < 14 || nometelmovel.length() < 15) {
                texterro10.setVisible(true);
                txe10 = 0;
            } else {
                texterro10.setVisible(false);
                txe10 = 1;
            }
            String nomecep = formattedTextField_CEP.getText().trim();
            if (nomecep.length() < 9) {
                texterro2.setVisible(true);
                txe2 = 0;
            } else {
                texterro2.setVisible(false);
                txe2 = 1;
            }

            String nomerua = ruadig.getText().trim();
            if (nomerua.isEmpty()) {
                texterro12.setVisible(true);
                txe12 = 0;
            } else {
                texterro12.setVisible(false);
                txe12 = 1;
            }

            String nomebairro = bairrodig.getText().trim();
            if (nomebairro.isEmpty()) {
                texterro13.setVisible(true);
                txe13 = 0;
            } else {
                texterro13.setVisible(false);
                txe13 = 1;
            }

            String nomesan = sangue.getSelectedItem().toString();
            vito = estado_devida.getSelectedItem().toString();
            if (vito.equals("vivo")) {
                vito = "1";
            } else {
                vito = "0";
            }
            casoconfir = caso_conf.getSelectedItem().toString();
            if (casoconfir.equals("confirmado")) {
                casoconfir = "1";
            } else {
                casoconfir = "0";
            }
            String nomenumero = spinnernumero.getValue().toString();
            if (txe1 == 1 && txe2 == 1 && txe3 == 1 && txe4 == 1 && txe5 == 1 && txe6 == 1 && txe7 == 1 && txe8 == 1 && txe9 == 1 && txe10 == 1 && txe12 == 1 && txe13 == 1) {
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            cadastrar.setEnabled(false);
                            cadastrob.setText("<html><font size=5 color=rgb(0,0,0)> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp     &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp CADASTRANDO...<html>");
                            Connection con = new con_pack.ConnectionFactory().getConnection();
                            PreparedStatement pesquisa = con.prepareStatement("Select Max(COD_CASO) from CASO ;");
                            ResultSet totalbd = pesquisa.executeQuery();
                            if (totalbd.next()) {
                                caso = totalbd.getInt("Max(COD_CASO)");
                            }
                            PreparedStatement pesquisa2 = con.prepareStatement("INSERT INTO CASO( COD_CASO,NOME,Idade,DT_nacimento,CPF,RG,PESO,ALTURA,T_SANGUINEO,NOME_PAI,NOME_MAE,DATA_REG,FATAL,CASO_CONFIRM,FK_CASO_ESTADO) VALUES(" + (caso + 1) + ",'" + nome + "'," + idade + ",'" + ano + "-" + mes + "-" + dia + "','" + namecpf + "','" + namerg + "'," + namepeso + "," + namealtura + ",'" + nomesan + "','" + nomepai + "','" + nomemae + "','" + anoh + "-" + mesh + "-" + diah + "'," + vito + "," + casoconfir + ",11);");
                            pesquisa2.executeUpdate();
                        } catch (SQLException | ClassNotFoundException | UnexpectedException ex) {
                            JOptionPane.showMessageDialog(null, "erro de conexão" + ex);
                        }

                        try {
                            Connection con = new con_pack.ConnectionFactory().getConnection();
                            PreparedStatement pesquisa3 = con.prepareStatement("INSERT INTO CONTATO(FK_CONTATO_CASO,TELEFONE_FIXO,TELEFONE_MOVEL,EMAIL) VALUES(" + (caso + 1) + ",'" + nometelfixo + "','" + nometelmovel + "','" + nomeemail + "');");
                            pesquisa3.executeUpdate();

                        } catch (SQLException | ClassNotFoundException | UnexpectedException ex) {
                            Logger.getLogger(drink.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            Connection con = new con_pack.ConnectionFactory().getConnection();
                            PreparedStatement pesquisa4 = con.prepareStatement("INSERT INTO ENDERECO(FK_ENDERECO_CASO,CEP,RUA,NUMERO,BAIRRO,ESTADO,CIDADE)  VALUES(" + (caso + 1) + ",'" + nomecep + "','" + nomerua + "'," + nomenumero + ",'" + nomebairro + "','" + "SP" + "','" + cidadenome + "');");
                            pesquisa4.executeUpdate();
                            cadastrob.setText("<html><font size=5 color=rgb(0,255,0)> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp     &nbsp &nbsp &nbsp &nbsp &nbsp CADASTRADO COM SUCESSO CASO NUMERO:" + (caso + 1) + "<html>");
                            cadastrar.setEnabled(true);
                        } catch (SQLException | ClassNotFoundException | UnexpectedException ex) {
                            Logger.getLogger(drink.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR O USUÁRIO VERIFIQUE SUA CONEXÃO COM SERVIDOR");
                        }
                    }
                }.start();
            }
            e.setSource(null);
        }
        if (e.getSource() == jb5) {
            System.exit(0);
        }
    }

    class CaretPosition extends FocusAdapter {

        @Override
        public void focusGained(FocusEvent e) {
            JTextComponent comp = (JTextComponent) e.getSource();
            comp.setCaretPosition(0);
        }
    }
}
