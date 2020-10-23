package viewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.User_Controller;
import model.UserDTO;

public class User_Viewer {

	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {

		User_Viewer uv = new User_Viewer();
		User_Controller uc = new User_Controller(); 
		uc.adminAccount();
		uv.showMenu();

	}
	
	private void login() throws IOException {
		
		User_Controller uc = new User_Controller();
		
		System.out.print("���̵� �Է� : ");
		String loginIdInput = br.readLine();
		System.out.print("��й�ȣ �Է� : ");
		String loginPassInput = br.readLine();
		uc.idPsCheck(loginIdInput, loginPassInput);
	}
	
	
	// ȸ�� ����
	private void register() throws IOException {
		
		User_Controller uc = new User_Controller();
		UserDTO ud = new UserDTO();
		
		System.out.printf("���̵� �Է� \n > ");
		ud.setUserAccountName(br.readLine()); 
		System.out.printf("��й�ȣ �Է� \n > ");
		ud.setUserPassword(br.readLine());
		System.out.printf("�г��� �Է� \n > ");
		ud.setUserNickname(br.readLine());
		
		uc.intoList(ud);
	}

	// ���θ޴�
	private void showMenu() throws NumberFormatException, IOException {

		while (true) {

			System.out.println("[ �Խ��� ���� ���α׷� ]");
			System.out.printf("# 1.�α���\n# 2.ȸ������\n# 3.����\n > ");
			String userInput = br.readLine();
			while (!userInput.matches("\\d*")) {
				System.out.print("���ڸ� �Է����ּ��� : ");
				userInput = br.readLine();
			}
			// �α���
			if (userInput.equals("1")) {
				login();
				
			}
			// ����
			else if (userInput.equals("2")) {
				
				register();

			}
			// ����
			else if (userInput.equals("3")) {
				System.out.println("�̿����ּż� �����մϴ�.");
				break;
			}
			// ����
			else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}

	}

}
