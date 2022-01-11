package com.example.oopbasic.encapsulation.example2;

public class Rental {
    private Movie movie;
    private int daysRented;

    public int getFrequentRenterPoints() {
        //기존 코드 - 기존엔 이렇게 렌탈 클래스에 렌탈 포인트 관련 로직이 있었지만 데이터를 들고 있는 부분이 영화 클래스에 더 많기 때문에 영화 클래스 내부로 캡슐화 시키는 것이 바람직하다는 판단이다
        /*
        처음엔 조건문 괄호 내의 부분 (movie.getPriceCode() == Movie.NEW_RELEASE) 이부분만 캡슐화 시키려고 했는데 생각해보니 별 차이가 없었고 영화의 데이터가 더 판별에 더 많은 영향을 끼치므로 전체로직을 영화로 캡슐화했다.
        if (movie.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }*/

        //개선코드 - 이렇게 영화 클래스 내부로 로직을 캡슐화 시키고 렌탈 데이터인 daysRented를 파라미터로 보낸다.
        return movie.verifyRenterPoints(this.daysRented);
    }
}
