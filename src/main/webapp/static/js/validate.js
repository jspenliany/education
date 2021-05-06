/*
For render the page, make sure that 'webapp' is added into the config option of run config as directory content.
And the 'war_exploded' mode is used.
*/


/*validate the account*/
export function validateUsername(rule, value, callback) {
    let minLength=6;
    let maxLength=30;
    if (value.length < minLength || value.length>maxLength) {
        return callback(new Error('用户名不得小于' + minLength +'位或者大于' + maxLength+ '位字符！'))
    } else {
        callback()
    }
}

/*validate the password*/
export function validatePassword(rule, value, callback) {
    let minLength=6;
    let maxLength=60;
    if (value.length < minLength || value.length>maxLength) {
        return callback(new Error('密码不得小于' + minLength +'位或者大于' + maxLength+ '位字符！'))
    } else {
        callback()
    }
}

/*validate email*/
export function validateEmail(rule, value, callback) {
    const emailReg = /^(([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5}{1,25})$/;

    if (!value) {
        return callback(new Error('邮箱不能为空！'))
    }

    setTimeout(() => {
        if (!emailReg.test(value)) {
            return callback(new Error('邮箱格式错误'))
        } else {
            callback()
        }
    }, 100)
}

/*validate the telephone NO.*/
export function validateTelephone(rule, value, callback) {
    const phoneReg = /^[1][3,4,5,7,8][0-9]{9}$/;
    if (!value) {
        return callback(new Error('手机号不能为空！！'))
    }

    setTimeout(() => {
        if (!phoneReg.test(value)) {
            return callback(new Error('手机号码格式错误'))
        } else {
            callback()
        }
    }, 100)
}