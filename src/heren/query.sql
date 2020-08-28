-- Database : MySQL
-- Table Name : midterm
-- name    subject     score
-- 여우      수학          50
-- 늑대      수학          80
-- 돼지      수학          70
-- 여우      국어          75
-- 늑대      국어          80
-- 돼지      국어          92
-- 여우      영어          98
-- 늑대      영어          60
-- 돼지      영어          55
--
-- 1. 총점(국어 + 영어 + 수학)이 높은 순으로 이름과 총점, 순위를 출력해주세요.

select DENSE_RANK() OVER (ORDER BY sum(score) DESC) 순위,
name as 이름, sum(score) as 총점
from midterm
group by name
order by sum(score) desc

-- 2. 각 과목별 최저 점수가 누구인지 이름, 과목, 점수를 출력해주세요.



-- 3. 총점이 200 점 넘은 사람은 누구인지 이름, 총점 출력해주세요.



-- 4. 늑대의 수학점수가 잘못 입력됐습니다. 수정을 해주세요.
--     늑대의 수학점수는 여우와 돼지의 수학점수 평균보다 15점이 더 높습니다.


