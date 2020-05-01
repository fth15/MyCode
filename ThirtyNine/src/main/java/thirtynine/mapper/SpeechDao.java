package thirtynine.mapper;

import org.apache.ibatis.annotations.*;
import thirtynine.pojo.Speech;

import java.util.List;

@Mapper
public interface SpeechDao {

    @Select("select * from speeches order by id desc")
    @Results({
        @Result(property = "user", column = "user_id", one =@One(select ="thirtynine.mapper.UserDao.getById") )
    })
    List<Speech> findAll();

    @Insert("insert into speeches(user_id,words,send_time) values(#{user.id},#{words},#{send_time})")
    void insertSpeech(Speech speech);

    @Delete("delete from speeches where id =#{id}")
    void deleteSpeech(int id);
}
