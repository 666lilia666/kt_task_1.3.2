import kotlin.math.abs

class Card(val _name: String, var _transferAmount: Int) {
    var _freeLimit: Int = 0

    constructor(
        _name: String,
        _transferAmount: Int,
        _freeLimit: Int,
    ) : this(
        _name, _transferAmount,
    ) {
        this._freeLimit = _freeLimit
    }

    var _commissionPercent: Double = 0.0

    constructor(
        _name: String,
        _transferAmount: Int,
        _freeLimit: Int,
        _commissionPercent: Double,
    ) : this(
        _name, _transferAmount, _freeLimit
    ) {
        this._commissionPercent = _commissionPercent
    }

    var _dopCommission: Int = 0

    constructor(
        _name: String,
        _transferAmount: Int,
        _freeLimit: Int,
        _commissionPercent: Double,
        _dopCommission: Int,
    ) : this(
        _name, _transferAmount, _freeLimit, _commissionPercent
    ) {
        this._dopCommission = _dopCommission
    }

    var _minCommission: Int = 0

    constructor(
        _name: String,
        _transferAmount: Int,
        _freeLimit: Int,
        _commissionPercent: Double,
        _dopCommission: Int,
        _minCommission: Int,
    ) : this(
        _name, _transferAmount, _freeLimit, _commissionPercent, _dopCommission
    ) {
        this._minCommission = _minCommission
    }

    fun commission(transferAmount: Int): Double {
        val difference = abs(_freeLimit - _transferAmount - transferAmount)
        val result: Double = when (_freeLimit) {
            0 -> when (_dopCommission) {
                0 -> when (_minCommission) {
                    0 -> transferAmount * _commissionPercent
                    else -> when (transferAmount * _commissionPercent < _minCommission) {
                        true -> _minCommission
                        else -> transferAmount * _commissionPercent
                    }
                }
                else -> transferAmount * _commissionPercent + _dopCommission
            } as Double
            else -> when (_transferAmount < _freeLimit && _transferAmount + transferAmount
                    < _freeLimit) {
                true -> 0.0
                else -> difference * _commissionPercent + _dopCommission
            }
        }
        return result
    }

    fun commissionMassage(transferAmount: Int) {
        val difference = abs(_freeLimit - _transferAmount - transferAmount)
        val result: Double = when (_freeLimit) {
            0 -> when (_dopCommission) {
                0 -> when (_minCommission) {
                    0 -> transferAmount * _commissionPercent
                    else -> when (transferAmount * _commissionPercent < _minCommission) {
                        true -> _minCommission
                        else -> transferAmount * _commissionPercent
                    }
                }
                else -> transferAmount * _commissionPercent + _dopCommission
            } as Double
            else -> when (_transferAmount < _freeLimit && _transferAmount + transferAmount
                    < _freeLimit) {
                true -> 0.0
                else -> difference * _commissionPercent + _dopCommission
            }
        }
        println("Комиссия за перевод по карте $_name составляет: ${result.toInt()} руб.")
    }

}
