package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//セッター・ゲッター・コンストラクタなどのコードをプログラマが書かなくても自動生成してくれる
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "diary")
@NamedQueries({
@NamedQuery(
        name = "getMyAllDiarys",
        query = "SELECT d FROM Diary AS d ORDER BY d.id DESC"
    ),
@NamedQuery(
        name = "getDiarysCount",
        query = "SELECT COUNT(d) FROM Diary AS d"
    )
})
public class Diary {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "iikoto", nullable = false)
    private String bodytext;

    //投稿日時
    @Column(name = "create_datetime", nullable = false)
    private Timestamp createDatetime;
}
