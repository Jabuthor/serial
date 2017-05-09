package br.univel.app;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import br.univel.xml.Produto;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnGerarDados = new JButton("Gerar Dados");
		btnGerarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gerarDados();
			}
		});
		GridBagConstraints gbc_btnGerarDados = new GridBagConstraints();
		gbc_btnGerarDados.anchor = GridBagConstraints.EAST;
		gbc_btnGerarDados.insets = new Insets(0, 0, 5, 5);
		gbc_btnGerarDados.gridx = 0;
		gbc_btnGerarDados.gridy = 0;
		contentPane.add(btnGerarDados, gbc_btnGerarDados);
		
		JButton btnGravarXml = new JButton("Gravar XML");
		GridBagConstraints gbc_btnGravarXml = new GridBagConstraints();
		gbc_btnGravarXml.insets = new Insets(0, 0, 5, 5);
		gbc_btnGravarXml.gridx = 1;
		gbc_btnGravarXml.gridy = 0;
		contentPane.add(btnGravarXml, gbc_btnGravarXml);
		
		JButton btnLerXml = new JButton("Ler XML");
		GridBagConstraints gbc_btnLerXml = new GridBagConstraints();
		gbc_btnLerXml.anchor = GridBagConstraints.WEST;
		gbc_btnLerXml.insets = new Insets(0, 0, 5, 0);
		gbc_btnLerXml.gridx = 2;
		gbc_btnLerXml.gridy = 0;
		contentPane.add(btnLerXml, gbc_btnLerXml);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

	protected void gerarDados() {
		List<Produto> lista = ProdutoUtil.newListProduto();
		MeuTableModel model = new MeuTableModel(lista);
		table.setModel(model);
	}

}
