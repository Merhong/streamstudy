package shop.mtcoding.streamstudy.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDetailDTO {
    private Integer id;
    private String title;
    private String content;
    private String author;

    // Board의 내용을 옮겨담아서 생성하는 생성자
    public BoardDetailDTO(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.author = board.getAuthor();
    }

    // 객체를 sout하면 toString이 자동 호출됨.
    // @Override
    // public String toString() {
    //     return "BoardDetailDTO [id=" + id + ... + "]" ;
    // }
}
