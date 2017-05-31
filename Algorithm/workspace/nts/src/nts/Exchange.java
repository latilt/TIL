package nts;

public class Exchange {

	public static void main(String[] args) {
		int expenses = 1000000;		// 총경비
		int exchangeRate = 1322;	// 환율
		int changes = expenses;		// 잔돈
		
		/* 환전하려는 A의 요구사항
		 * 지폐 종류별 1장 이상씩 환전 하였으면 좋겠다. -> 기본값은 1이상
		 * 100N은 4장, 50N은 4장만 환전하고 싶다. -> 100N과 50N은 라운드로빈 할 필요 없으며 4장씩의 금액을 미리 빼고 계산한다.
		 * 1N은 20장 이상 환전하고 싶다. -> 1N은 라운드로빈을 하며 20장의 금액을 미리 빼고 계산한다.
		 * {100N, 50N, 20N, 10N, 5N, 1N}
		 */
		int[] amount = {4, 4, 1, 1, 1, 20};
		
		/*
		 * 라운드로빈 전 요구사항에 맞출 수 있도록 필요금액을 빼준다.
		 */
		changes = changes - ((100 * amount[0] + 50 * amount[1] + 20 * amount[2] + 10 * amount[3] + 5 * amount[4] + 1 * amount[5]) * exchangeRate);
		
		/* 20N부터 1N까지 라운드로빈 -> 잔돈이 일정량 이상인 동안 while문을 돌며 순차적으로 환전
		 * 우리돈 2,000원 이하는 잔돈으로 받고 싶다. -> 잔돈이 2000이하가 되면 중지
		 */
		while(changes > 2000) {
			if(changes - 20 * exchangeRate >= 0) {
				changes = changes - 20 * exchangeRate;
				amount[2]++;
			}
			if(changes - 10 * exchangeRate >= 0) {
				changes = changes - 10 * exchangeRate;
				amount[3]++;
			}
			if(changes - 5 * exchangeRate >= 0) {
				changes = changes - 5 * exchangeRate;
				amount[4]++;
			}
			if(changes - exchangeRate >= 0) {
				changes = changes - exchangeRate;
				amount[5]++;
			}
		}
		
		System.out.println("100N : " + amount[0] + "장");
		System.out.println("50N : " + amount[1] + "장");
		System.out.println("20N : " + amount[2] + "장");
		System.out.println("10N : " + amount[3] + "장");
		System.out.println("5N : " + amount[4] + "장");
		System.out.println("1N : " + amount[5] + "장");
		System.out.println("잔돈 : " + changes + "원");
	}
}
