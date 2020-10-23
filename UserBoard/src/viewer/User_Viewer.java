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
		
		System.out.print("아이디 입력 : ");
		String loginIdInput = br.readLine();
		System.out.print("비밀번호 입력 : ");
		String loginPassInput = br.readLine();
		uc.idPsCheck(loginIdInput, loginPassInput);
	}
	
	
	// 회원 가입
	private void register() throws IOException {
		
		User_Controller uc = new User_Controller();
		UserDTO ud = new UserDTO();
		
		System.out.printf("아이디 입력 \n > ");
		ud.setUserAccountName(br.readLine()); 
		System.out.printf("비밀번호 입력 \n > ");
		ud.setUserPassword(br.readLine());
		System.out.printf("닉네임 입력 \n > ");
		ud.setUserNickname(br.readLine());
		
		uc.intoList(ud);
	}

	// 메인메뉴
	private void showMenu() throws NumberFormatException, IOException {

		while (true) {

			System.out.println("[ 게시판 관리 프로그램 ]");
			System.out.printf("# 1.로그인\n# 2.회원가입\n# 3.종료\n > ");
			String userInput = br.readLine();
			while (!userInput.matches("\\d*")) {
				System.out.print("숫자만 입력해주세요 : ");
				userInput = br.readLine();
			}
			// 로그인
			if (userInput.equals("1")) {
				login();
				
			}
			// 가입
			else if (userInput.equals("2")) {
				
				register();

			}
			// 종료
			else if (userInput.equals("3")) {
				System.out.println("이용해주셔서 감사합니다.");
				break;
			}
			// 오류
			else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}

	}

}
