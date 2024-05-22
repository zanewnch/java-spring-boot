class Result<T> {
    code: number;
    msg: string | null;
    data: T | null;

    constructor(code: number, msg: string | null, data: T | null) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    static success<T>(): Result<T> {
        return new Result<T>(1, null, null);
    }

    static successWithData<T>(data: T): Result<T> {
        return new Result<T>(1, null, data);
    }

    static error<T>(msg: string): Result<T> {
        return new Result<T>(0, msg, null);
    }
}

export default Result;