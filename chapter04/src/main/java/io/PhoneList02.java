package io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhoneList02 {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			File file = new File("phone.txt");

			if (!file.exists()) {
				System.out.println("파일이 존재하지 않습니다.");
				return;
			}
			System.out.println("================== 파일정보 =======================");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format((new Date(file.lastModified()))));
			System.out.println();
			System.out.println("================== 전화번호 =======================");
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String name = sc.next();
				String phone1 = sc.next();
				String phone2 = sc.next();
				String phone3 = sc.next();

				System.out.println(name + ":" + phone1 + "-" + phone2 + "-" + phone3);
			}

		} catch (IOException e) {
			System.out.println("error : " + e);
		} finally {
			sc.close();
		}
	}
}
