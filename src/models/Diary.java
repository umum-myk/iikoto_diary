package models;

import java.sql.Date;

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
    ),
@NamedQuery(
        name = "getMonth",
        query = "SELECT DISTINCT d FROM Diary AS d GROUP BY d.createMonth , d.createYear"
    ),
@NamedQuery(
        name = "getDiarysMonth",
        query = "SELECT d FROM Diary AS d  WHERE d.createMonth = :MonthFind AND d.createYear = :YearFind "
    ),
@NamedQuery(
        name = "getSortMonth",
        query = "SELECT d FROM Diary AS d  WHERE d.createMonth = :MonthFind AND d.createYear = :YearFind AND d.iine = 1"
    ),
@NamedQuery(
        name = "getDiarysSearch",
        query = "SELECT d FROM Diary AS d  WHERE d.bodytext LIKE :IndexFind "
    ),
@NamedQuery(
        name = "getDiarysSearchNumber",
        query = "SELECT COUNT(d) FROM Diary AS d  WHERE d.bodytext LIKE :IndexFind "
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
    @Column(name = "create_date", nullable = false)
    private Date createDate;

    //月集計用
    @Column(name = "create_month", nullable = false)
    private Integer createMonth;

    //年集計用
    @Column(name = "create_year", nullable = false)
    private Integer createYear;

    //いいね
    @Column(name = "iine", nullable = false)
    private Integer iine ;


}
