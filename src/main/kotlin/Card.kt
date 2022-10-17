class Card(val _name: String, val _dayLimit: Int, val _mothLimit: Int, var _transferAmount: Int) {
    var _freeLimit: Int = 0

    constructor(_name: String, _dayLimit: Int, _mothLimit: Int, _transferAmount: Int, _freeLimit: Int) : this(
        _name, _dayLimit, _mothLimit, _transferAmount,
    ) {
        this._freeLimit = _freeLimit
    }

}