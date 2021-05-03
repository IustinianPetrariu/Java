import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) {

        Server server = new Server();
        server.initialize();
        server.start();


        create or replace procedure my_query(sql_qury in VARCHAR2) as


        v_cursor INTEGER;
        v_check_status INTEGER;
        v_number_var NUMBER;
        v_date_var DATE;
        v_columns_number NUMBER;

        v_description_tab DBMS_SQL.DESC_TAB;

        v_indexul_coloanei NUMBER;

        v_my_statement VARCHAR2(100);

        v_mystring_var VARCHAR(100);

        BEGIN

        v_cursor := DBMS_SQL.OPEN_CURSOR;

        v_my_statement := sql_qury;

        DBMS_SQL.PARSE(v_cursor,v_my_statement,DBMS_SQL.NATIVE);

        v_check_status := DBMS_SQL.EXECUTE(v_cursor);
        DBMS_SQL.DESCRIBE_COLUMNS(v_cursor,v_columns_number,v_description_tab);

        v_indexul_coloanei := v_description_tab.FIRST;
        IF(v_indexul_coloanei IS NOT NULL) THEN
                LOOP
        FOR i in 1..v_columns_number LOOP
        IF(v_description_tab(i).col_type = 1) THEN
        DBMS_SQL.DEFINE_COLUMN(v_cursor,i,v_mystring_var,200);
        ELSIF(v_description_tab(i).col_type = 2) THEN
        DBMS_SQL.DEFINE_COLUMN(v_cursor,i,v_number_var);
        ELSIF(v_description_tab(i).col_type = 12)  THEN
        DBMS_SQL.DEFINE_COLUMN(v_cursor,i,v_date_var);
        END IF;
        END LOOP;

        IF DBMS_SQL.FETCH_ROWS(v_cursor)>0 THEN
        v_indexul_coloanei := v_description_tab.FIRST;
        LOOP
        IF (v_indexul_coloanei IS NULL) then
                 EXIT;
          END IF;

        IF(v_description_tab(v_indexul_coloanei).col_type = 2) THEN
        DBMS_SQL.COLUMN_VALUE(v_cursor,v_indexul_coloanei,v_number_var);
        DBMS_OUTPUT.PUT_LINE(v_number_var);



        ELSIF(v_description_tab(v_indexul_coloanei).col_type = 1)  THEN
        DBMS_SQL.COLUMN_VALUE(v_cursor,v_indexul_coloanei,v_mystring_var);
        DBMS_OUTPUT.PUT_LINE(v_mystring_var);


        ELSIF(v_description_tab(v_indexul_coloanei).col_type = 12)  THEN
        DBMS_SQL.COLUMN_VALUE(v_cursor,v_indexul_coloanei,v_date_var);
        DBMS_OUTPUT.PUT_LINE(v_date_var);
        END IF;
        v_indexul_coloanei := v_description_tab.next(v_indexul_coloanei);
        END LOOP;
        ELSE
                EXIT;
        END IF;
        END LOOP;
        END IF;
        DBMS_SQL.CLOSE_CURSOR(v_cursor);
        END;




    }
}
