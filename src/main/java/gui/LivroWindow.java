package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dto.LivroDTO;
import service.LivroService;

public class LivroWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtAnoPublic;
	private JTextField txtNumPaginas;
	private JTable tblLivros;
	

	
	
	public LivroWindow(){
		this.iniciarComponentes();
	}
	protected void finalizarAplicacao() {
		// TODO Auto-generated method stub
		
	}
	protected void buscarLivro() {
		// TODO Auto-generated method stub
		
	}
	protected void cadastrar() {
		try {
			LivroDTO livro = new LivroDTO();
			LivroService service = new LivroService();
			livro.setAnoPublicacao(Integer.parseInt(txtAnoPublic.getText().trim()));
			livro.setAutorPrincipal(txtAutor.getText().trim());
			livro.setNumeroPaginas(Integer.parseInt(txtNumPaginas.getText().trim()));
			livro.setTitulo(txtTitulo.getText().trim());
			
			int resultado = service.cadastrar(livro);
			
			
		}catch(NumberFormatException a){
		
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	protected void atualizarLivro() {
		// TODO Auto-generated method stub
		
	}
	protected void excluirLivro() {
		// TODO Auto-generated method stub
		
	}
	protected void limparComponentes() {
		
		
	}
	
	private void iniciarComponentes() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 560);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 620, 500);
		panel.setLayout(null);
		contentPane.add(panel);

		// ---------- Menu ----------
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 620, 23);
		panel.add(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalizarAplicacao();
			}
		});
		mnArquivo.add(mntmSair);

		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);

		// ---------- Título ----------
		JLabel lblCadastrarLivro = new JLabel("Cadastro de Livros");
		lblCadastrarLivro.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCadastrarLivro.setBounds(200, 30, 240, 30);
		panel.add(lblCadastrarLivro);

		// ---------- ID + Buscar ----------
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(40, 72, 120, 18);
		panel.add(lblId);

		txtId = new JTextField();
		txtId.setBounds(170, 70, 100, 22);
		panel.add(txtId);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarLivro();
			}
		});
		btnBuscar.setBounds(285, 69, 90, 24);
		panel.add(btnBuscar);

		// ---------- Título ----------
		JLabel lblTitulo = new JLabel("Título");
		lblTitulo.setBounds(40, 102, 120, 18);
		panel.add(lblTitulo);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(170, 100, 300, 22);
		panel.add(txtTitulo);

		// ---------- Autor ----------
		JLabel lblAutor = new JLabel("Autor Principal");
		lblAutor.setBounds(40, 132, 120, 18);
		panel.add(lblAutor);

		txtAutor = new JTextField();
		txtAutor.setBounds(170, 130, 300, 22);
		panel.add(txtAutor);

		// ---------- Ano ----------
		JLabel lblAnoPublic = new JLabel("Ano de Publicação");
		lblAnoPublic.setBounds(40, 162, 130, 18);
		panel.add(lblAnoPublic);

		txtAnoPublic = new JTextField();
		txtAnoPublic.setBounds(170, 160, 100, 22);
		panel.add(txtAnoPublic);

		// ---------- Páginas ----------
		JLabel lblNumPaginas = new JLabel("Nº de Páginas");
		lblNumPaginas.setBounds(40, 192, 120, 18);
		panel.add(lblNumPaginas);

		txtNumPaginas = new JTextField();
		txtNumPaginas.setBounds(170, 190, 100, 22);
		panel.add(txtNumPaginas);

		// ---------- Botões ----------
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
			}
		});

		btnCadastrar.setBounds(40, 230, 110, 27);
		panel.add(btnCadastrar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarLivro();
			}
		});
		btnAtualizar.setBounds(160, 230, 110, 27);
		panel.add(btnAtualizar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirLivro();
			}
		});
		btnExcluir.setBounds(280, 230, 110, 27);
		panel.add(btnExcluir);

		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparComponentes();
			}
		});
		btnLimparCampos.setBounds(400, 230, 130, 27);
		panel.add(btnLimparCampos);

		// ---------- Tabela ----------
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 275, 580, 200);
		panel.add(scrollPane);

		tblLivros = new JTable();
		tblLivros.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] { "ID", "Título", "Autor", "Ano", "Páginas" }));
		tblLivros.getColumnModel().getColumn(0).setPreferredWidth(40);
		tblLivros.getColumnModel().getColumn(1).setPreferredWidth(220);
		tblLivros.getColumnModel().getColumn(2).setPreferredWidth(160);
		tblLivros.getColumnModel().getColumn(3).setPreferredWidth(70);
		tblLivros.getColumnModel().getColumn(4).setPreferredWidth(70);
		scrollPane.setViewportView(tblLivros);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LivroWindow frame = new LivroWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
