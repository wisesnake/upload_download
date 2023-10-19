package sec01.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download.do")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);

	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		    // 응닑 헤더 설정: 텍스트 형식의 응답을 UTF-8 문자 집합으로 설정
		    response.setContentType("text/html; charset=utf-8");
		    
		    // 콘솔에 출력: 현재 서블릿의 동작을 디버깅 목적으로 로그에 기록
		    System.out.println("이 구간은 다운로드 서블릿");

		    // 파일 저장 디렉토리 경로 설정
		    String file_repo = "C:/ex/fileRepo";

		    // HTTP 요청에서 'fileName' 파라미터를 가져오기
		    String fileName = (String) request.getParameter("fileName");
		    System.out.println(fileName);

		    // HTTP 응답 스트림 가져오기
		    OutputStream os = response.getOutputStream();

		    // 다운로드할 파일 경로 생성
		    String downFile = file_repo + "/" + fileName;
		    System.out.println(downFile);

		    // 다운로드할 파일을 나타내는 File 객체 생성
		    File f = new File(downFile);
		    System.out.println("파일 객체 : " + f);

		    // 파일 이름을 UTF-8로 인코딩하여 브라우저가 한국어 파일 이름을 올바르게 표시하도록 함
		    String encodedFileName = URLEncoder.encode(fileName, "UTF-8");

		    // 캐시 제어 헤더 설정: 캐싱을 비활성화
		    response.setHeader("Cache-Control", "no-cache");

		    // 다운로드 헤더 설정: 브라우저에게 다운로드할 파일로 처리하도록 지시
		    response.addHeader("Content-disposition", "attachment; fileName=" + fileName);

		    // 다운로드할 파일을 읽기 위한 FileInputStream 생성
		    FileInputStream in = new FileInputStream(f);

		    // 파일 데이터를 읽어서 응답 스트림으로 전송
		    byte[] buffer = new byte[1024 * 8];
		    while (true) {
		        int count = in.read(buffer);
		        if (count == -1)
		            break;
		        // 응답 스트림으로 파일 데이터를 쓰기
		        os.write(buffer, 0, count);
		    }

		    // 파일 입력 스트림과 응답 스트림 닫기
		    in.close();
		    os.close();
		}
//	서블릿이 실행될 때, HTTP 응답의 콘텐츠 타입을 "text/html; charset=utf-8"로 설정하고, 콘솔에 디버그 로그를 출력합니다.
//	파일 저장 디렉토리 경로를 설정하고, HTTP 요청에서 'fileName' 파라미터를 가져옵니다.
//	HTTP 응답 스트림을 얻어옵니다.
//	다운로드할 파일의 경로를 생성하고 File 객체로 나타냅니다.
//	파일 이름을 UTF-8로 인코딩하여 한국어 파일 이름을 올바르게 처리하도록 합니다.
//	캐싱을 비활성화하고, 브라우저에게 다운로드할 파일로 처리하도록 헤더를 설정합니다.
//	다운로드할 파일을 FileInputStream을 사용하여 읽어오고, 데이터를 응답 스트림으로 전송합니다.
//	파일 읽기가 완료되면 파일 입력 스트림과 응답 스트림을 닫습니다.
}
