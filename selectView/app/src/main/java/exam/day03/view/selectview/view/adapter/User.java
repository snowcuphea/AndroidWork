package exam.day03.view.selectview.view.adapter;
//row에 출력할 데이터 정보를 담는 객체(=DTO)
//외부에서 변수로 접근한다.
public class User {
    int myImg;
    String name;
    String telNum;


    public User(int myImg, String name, String telNum) {
        this.myImg = myImg;
        this.name = name;
        this.telNum = telNum;
    }

    //toString은 기능상 필요없지만, 잘 작동하나 확인하기 위해 추가한 것
    @Override
    public String toString() {
        return "User{" +
                "myImg=" + myImg +
                ", name='" + name + '\'' +
                ", telNum='" + telNum + '\'' +
                '}';
    }
}