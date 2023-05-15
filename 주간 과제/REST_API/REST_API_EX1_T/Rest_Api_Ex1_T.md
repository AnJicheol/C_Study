

```java
package com.example.rest_api_ex1.controller;  
  
import com.example.rest_api_ex1.service.movieService;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  
  
@RestController  
public class movieController {  
    private final movieService movieservice = new movieService();  
  
    @GetMapping("/chart")  
    public String movieController(){  
        return movieservice.getChart();  
    }  
}
```

```java

package com.example.rest_api_ex1.dto;  
  
import com.example.rest_api_ex1.db;  
  
// 1주차 문제는 스터디 진도상 데이터베이스 아닌 간단한 리스트 활용함  
public class movieDto {  
    db DB = new db();  
  
    @Override  
    public String toString(){  
  
        return "chart" + DB.get_movie_data().toString();  
    }  
}

```

```java
package com.example.rest_api_ex1.service;  
  
import com.example.rest_api_ex1.dto.movieDto;  
  
public class movieService {  
    private movieDto moviedto = new movieDto();  
  
    public String getChart() {  
  
  
        return moviedto.toString();  
    }  
}

```

```java
package com.example.rest_api_ex1;  
  
import java.util.ArrayList;  
  
// 1주차 문제는 스터디 진도상 데이터베이스 아닌 간단한 리스트 활용함  
// 따라서 해당 클래스 movie 리스트에 순위 - 이름 으로 초기화된 값이 저장되었다고 가정함  
  
public class db {  
    public ArrayList<String> movie = new ArrayList<>();  
  
    public void db(){  
        movie.add("{순위 : 1 , 이름 : 인터스텔라 }");  
        movie.add("{순위 : 2 , 이름 : 듄 }");  
        movie.add("{순위 : 3 , 이름 : 존윅4 }");  
        movie.add("{순위 : 4 , 이름 : 너의 이름은 }");  
        movie.add("{순위 : 5 , 이름 : 틴틴 }");  
        movie.add("{순위 : 6 , 이름 : 스펀지밥 핑핑이 구출 대작전 }");  
        movie.add("{순위 : 7 , 이름 : 라라랜드 }");  
        movie.add("{순위 : 8 , 이름 : 아이언맨 }");  
        movie.add("{순위 : 9 , 이름 : 겨울 왕국 }");  
        movie.add("{순위 : 11 , 이름 : 해리 포타 }");  
    }  
  
    public ArrayList<String> get_movie_data(){  
        db();  
        return movie;  
    }  
}
```

```java

결과

chart[{순위 : 1 , 이름 : 인터스텔라 }, {순위 : 2 , 이름 : 듄 }, {순위 : 3 , 이름 : 존윅4 }, {순위 : 4 , 이름 : 너의 이름은 }, {순위 : 5 , 이름 : 틴틴 }, {순위 : 6 , 이름 : 스펀지밥 핑핑이 구출 대작전 }, {순위 : 7 , 이름 : 라라랜드 }, {순위 : 8 , 이름 : 아이언맨 }, {순위 : 9 , 이름 : 겨울 왕국 }, {순위 : 11 , 이름 : 해리 포타 }]

```