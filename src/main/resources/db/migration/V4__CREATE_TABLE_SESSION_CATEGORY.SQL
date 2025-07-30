CREATE TABLE tb_session_category (
    session_id INTEGER,
    category_id INTEGER,
    CONSTRAINT fk_tb_session_category_session FOREIGN KEY(session_id) REFERENCES tb_session(id),
    CONSTRAINT fk_tb_session_category_category FOREIGN KEY(category_id) REFERENCES tb_category(id)
);
